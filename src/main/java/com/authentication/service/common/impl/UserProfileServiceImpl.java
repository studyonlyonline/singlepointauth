package com.authentication.service.common.impl;

import com.authentication.beans.constants.UserTypeEnum;
import com.authentication.beans.requestVO.UserCreateCorporateProfileVO;
import com.authentication.beans.requestVO.UserCreateProfileInfoVO;
import com.authentication.beans.requestVO.UserLoginInfoVO;
import com.authentication.beans.responseVO.*;
import com.authentication.beans.responseVO.responseGeneratorUtils.ResponseBuilderUtils;
import com.authentication.db.dao.IUserRepository;
import com.authentication.db.dao.UserCorporateProfileRepository;
import com.authentication.db.dao.UserLoginInfoRepository;
import com.authentication.db.dao.UserProfileRepository;
import com.authentication.db.entity.UserCorporateProfileEntity;
import com.authentication.db.entity.UserEntity;
import com.authentication.db.entity.UserProfileEntity;
import com.authentication.service.common.IUserProfileService;
import com.authentication.service.common.convertors.UserProfileConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class UserProfileServiceImpl implements IUserProfileService {

    @Autowired
    private UserLoginInfoRepository userLoginInfoRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserProfileConvertor userProfileConvertor;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserCorporateProfileRepository userCorporateProfileRepository;

    @Override
    public UserCreateProfileResponseVO createNewProfile(UserCreateProfileInfoVO userCreateProfileInfoVO) {
        try {
            UserEntity userEntity = userRepository.getUserEntityFromEmailOrSso(userCreateProfileInfoVO.getEmailId(),
                    userCreateProfileInfoVO.getSsoToken(),
                    userCreateProfileInfoVO.getOrganizationId());
            if (Objects.isNull(userEntity)) {
                throw new Exception("No user exists for which profile can be created. Create user first");
            }
            userCreateProfileInfoVO.setEmailId(userEntity.getEmail());
            userCreateProfileInfoVO.setUserId(userEntity.getUserId());
            userCreateProfileInfoVO.setOrganizationId(userEntity.getOrganizationId());
            if(!checkProfileExist(userCreateProfileInfoVO.getEmailId(), userCreateProfileInfoVO.getOrganizationId())){
               throw new Exception("already Exist");
            }
            UserProfileEntity userProfileEntity = userProfileConvertor.convertUserCreateProfileInfoVOToEntity(userCreateProfileInfoVO);
            userProfileEntity = userProfileRepository.save(userProfileEntity);
            return prepareResponse(userProfileEntity, null);
        } catch (Exception ex){
            return prepareResponse(null, ex.getMessage());
        }
    }

    @Override
    public UserCreateProfileResponseVO createNewCorporateProfile(UserCreateCorporateProfileVO userCreateCorporateProfileVO) {
        try {
            if(null == userCreateCorporateProfileVO.getGstin()
                    && null == userCreateCorporateProfileVO.getAadharNo()){
                throw new Exception("Both GSTIN, Aadhar no are empty");
            }
            UserEntity userEntity = userRepository.getUserEntityFromEmailOrSso(userCreateCorporateProfileVO.getEmailId(),
                    userCreateCorporateProfileVO.getSsoToken(),
                    userCreateCorporateProfileVO.getOrganizationId());
            if (Objects.isNull(userEntity)) {
                throw new Exception("No user exists for which profile can be created. Create user first");
            }
            userCreateCorporateProfileVO.setEmailId(userEntity.getEmail());
            userCreateCorporateProfileVO.setUserId(userEntity.getUserId());
            userCreateCorporateProfileVO.setOrganizationId(userEntity.getOrganizationId());
            if(!checkCorporateProfileExist(userCreateCorporateProfileVO.getEmailId(), userCreateCorporateProfileVO.getOrganizationId())){
                throw new Exception("Corporate Profile Already Exist");
            }
            UserCorporateProfileEntity userCorporateProfileEntity = userProfileConvertor.convertCreateCorporateProfileVOToEntity(userCreateCorporateProfileVO);
            createProfileAndUpdateuserEntity(userCorporateProfileEntity,userEntity);
            return prepareResponseForCorporate(userCorporateProfileEntity, null);
        } catch (Exception ex){
            return prepareResponseForCorporate(null, ex.getMessage());
        }
    }

    @Override
    public UserInfoResponseVO getUserInfo(UserLoginInfoVO userLoginInfoVO) {
        try {
            UserEntity userEntity = userRepository.getUserEntityFromEmailOrSso(userLoginInfoVO.getEmailId(),
                    userLoginInfoVO.getSsoToken(),
                    userLoginInfoVO.getOrganizationId());
        if (Objects.isNull(userEntity)) {
            throw new Exception("No such user exists");
        }
        UserProfileEntity userProfileEntity =
                userProfileRepository.findUserByEmailAndOrganization(userEntity.getEmail(), userEntity.getOrganizationId());
        UserCorporateProfileEntity userCorporateProfileEntity =
                userCorporateProfileRepository.findUserByEmailAndOrganization(userEntity.getEmail(), userEntity.getOrganizationId());
        return prepareCompleteUserInfoResponse(userEntity, userProfileEntity, userCorporateProfileEntity, null);
        } catch (Exception ex){
            return prepareCompleteUserInfoResponse(null, null, null, ex.getMessage());
        }
    }

    @Transactional
    private void createProfileAndUpdateuserEntity(UserCorporateProfileEntity userCorporateProfileEntity, UserEntity userEntity){
        userCorporateProfileEntity = userCorporateProfileRepository.save(userCorporateProfileEntity);
        userEntity.setUserType(UserTypeEnum.DEALER);
        userRepository.save(userEntity);
    }

    private boolean checkCorporateProfileExist(String email, String organizationId){
        UserCorporateProfileEntity userCorporateProfileEntity = userCorporateProfileRepository.findUserByEmailAndOrganization(email, organizationId);
        if (Objects.isNull(userCorporateProfileEntity)){
            return true;
        }
        return false;
    }

    private boolean checkProfileExist(String email, String organizationId){
        UserProfileEntity userProfileEntity = userProfileRepository.findUserByEmailAndOrganization(email, organizationId);
        if (Objects.isNull(userProfileEntity)){
            return true;
        }
        return false;
    }

    private UserCreateProfileResponseVO prepareResponse(UserProfileEntity userProfileEntity, String message){
        if(Objects.isNull(userProfileEntity)){
            return UserCreateProfileResponseVO.builder()
                    .metaNode(ResponseBuilderUtils.userProfileCreationFailed(message))
                    .build();
        }
        return UserCreateProfileResponseVO.builder()
                .metaNode(ResponseBuilderUtils.userProfileCreationSuccessful())
                .build();
    }

    private UserCreateProfileResponseVO prepareResponseForCorporate(UserCorporateProfileEntity userCorporateProfileEntity,
                                                                    String message){
        if(Objects.isNull(userCorporateProfileEntity)){
            return UserCreateProfileResponseVO.builder()
                    .metaNode(ResponseBuilderUtils.userProfileCreationFailed(message))
                    .build();
        }
        return UserCreateProfileResponseVO.builder()
                .metaNode(ResponseBuilderUtils.userProfileCreationSuccessful())
                .build();
    }

    private UserInfoResponseVO prepareCompleteUserInfoResponse(UserEntity userEntity,
                                                               UserProfileEntity userProfileEntity,
                                                               UserCorporateProfileEntity userCorporateProfileEntity,
                                                               String message){
        if(Objects.isNull(userEntity)){
            return UserInfoResponseVO.builder()
                    .metaNode(ResponseBuilderUtils.userCompleteInfoFailed(message))
                    .build();
        }
        return UserInfoResponseVO.builder()
                .metaNode(ResponseBuilderUtils.userCompleteInfoSuccess())
                .userInfoResponseDataNode(prepareUserInfoResponseDataNode(userEntity,userProfileEntity, userCorporateProfileEntity))
                .build();
    }

    private UserInfoResponseDataNode prepareUserInfoResponseDataNode(UserEntity userEntity,
                                                                     UserProfileEntity userProfileEntity,
                                                                     UserCorporateProfileEntity userCorporateProfileEntity){
        return UserInfoResponseDataNode.builder()
                .email(userEntity.getEmail())
                .mobileNo(userEntity.getMobileNo())
                .mobileIsdCode(userEntity.getMobileISDCode())
                .emailVerified(userEntity.getIsEmailVerified())
                .mobileVerified(userEntity.getIsMobileVerified())
                .userType(userEntity.getUserType().name())
                .accountActive(!userEntity.getIsAccountDeleted())
                .userInfoProfileResponseVO(prepareUserInfoProfileResponseVO(userProfileEntity))
                .userInfoCorporateProfileResponseVO(prepareUserInfoCorporateProfileResponseVO(userCorporateProfileEntity))
                .build();
    }

    private UserInfoProfileResponseVO prepareUserInfoProfileResponseVO(UserProfileEntity userProfileEntity){
        if(Objects.isNull(userProfileEntity)){
            return null;
        }
        return UserInfoProfileResponseVO.builder()
                .firstName(userProfileEntity.getFirstname())
                .lastName(userProfileEntity.getLastname())
                .address(userProfileEntity.getAddress())
                .pincode(userProfileEntity.getPincode())
                .verifiedProfile(userProfileEntity.getProfileVerified())
                .build();
    }

    private UserInfoCorporateProfileResponseVO prepareUserInfoCorporateProfileResponseVO(UserCorporateProfileEntity userCorporateProfileEntity){
        if(Objects.isNull(userCorporateProfileEntity)){
            return null;
        }
        return UserInfoCorporateProfileResponseVO.builder()
                .firmName(userCorporateProfileEntity.getFirmName())
                .gstin(userCorporateProfileEntity.getGstin())
                .aadharNo(userCorporateProfileEntity.getAadharNo())
                .billingAddress(userCorporateProfileEntity.getBillingAddress())
                .corporateProfileVerified(userCorporateProfileEntity.getProfileVerified())
                .build();
    }



}
