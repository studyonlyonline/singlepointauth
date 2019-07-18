# singlepointauth
Single sign on service to be used for any application

## Register User (POST):
URL : localhost:9090/service/registerUser <br>
Request Body:  
```json
{
      "email": "test2@gmail.com"
      "password":"test123",
      "organizationId":"plastic"
 } 
```
               


## Login User By EmailId(POST)
URL : localhost:9090/service/login <br>
Request Body:<br> 
              { <br>
              	"email": "test@gmail.com",       //mandatory <br>
              	"password": "test123",           //mandatory <br>
              	"organizationId" : "plastic"     //mandatory <br>
              }

Response Body:<br> 
              { <br>
                   "meta": { <br>
                       "statusCode": "200", <br>
                       "statusMessage": "Successfully logged in.", <br>
                       "developerMessage": null, <br>
                       "timestamp": "2019-07-19T00:24:42.726" <br>
                   }, <br>
                   "data": { <br>
                       "emailId": "test2@gmail.com", <br>
                       "ssoToken": "33b016d8-57d8-4cd8-9a12-19281862c3c1" <br>
                   } <br>
               } <br>

Set the above ssoToken in cookie with key as "ssoToken" and value as ssoToken value in response. <br>
The above cookie then will be sent in subsequent request to verify the user and get its details. <br>


## Logout User By EmailId + ssoToken (POST)
URL : localhost:9090/service/logout
Request Body:  
              ```json 
              {
              	"email": "test2@gmail.com",
              	"ssoToken" : "33b016d8-57d8-4cd8-9a12-19281862c3c1"
              } 
              ```


Response Body: {
                   "meta": {
                       "statusCode": "200",
                       "statusMessage": "Successfully logged out",
                       "developerMessage": null,
                       "timestamp": "2019-07-19T00:58:01.757"
                   }
               }

## Create Profile (POST)

### With Email and OrganizationID (no login)

URL: localhost:9090/service/create-profile
Request Body : 
              ```{
               	"emailId" : "test2@gmail.com",             // mandatory
               	"organizationId" : "plastic",              // mandatory
               	"firstname" : "test",                      // mandatory
               	"lastName" : "gupta",                      // optional
               	"address"  : "87/12 k kanpur",             // optional
               	"pincode"  : "208003"                       // optional
               }```

Response : {
               "meta": {
                   "statusCode": "200",
                   "statusMessage": "Successfully Profile Created.",
                   "developerMessage": null,
                   "timestamp": "2019-07-19T00:16:38.147"
               }
           }

### With ssoToken (logged in User)
URL: localhost:9090/service/create-profile
RequestBody : {
              	"ssoToken" : "33b016d8-57d8-4cd8-9a12-19281862c3c1",
              	"firstname" : "test",
              	"lastname" : "jain",
              	"address"  : "987/H -G plot 6 Delhi",
              	"pincode"  : "122011"
              }

Response : {
               "meta": {
                   "statusCode": "200",
                   "statusMessage": "Successfully Profile Created.",
                   "developerMessage": null,
                   "timestamp": "2019-07-19T00:38:23.431"
               }
           }


## Create Corporate Profile (POST)

### With Email and OrganizationID (no login)

URL: localhost:9090/service/create-corporate-profile
RequestBody : {
              	"email" : "test2@gmail.com",
              	"organizationId" : "plastic",
              	"firmName" : "testing solutions pvt ltd",
              	"gstin" : "AGP21334ASDF564",
              	"aadharNo" : "123412341234",
              	"billingAddress"  : "london"
              }

Response : {
               "meta": {
                   "statusCode": "200",
                   "statusMessage": "Successfully Profile Created.",
                   "developerMessage": null,
                   "timestamp": "2019-07-19T00:42:42.75"
               }
           }

### With ssoToken (logged in user)
URL: localhost:9090/service/create-corporate-profile
RequestBody : {
              	"ssoToken" : "33b016d8-57d8-4cd8-9a12-19281862c3c1",
              	"firmName" : "testing solutions pvt ltd",
              	"gstin" : "AGP21334ASDF564",
              	"aadharNo" : "123412341234",
              	"billingAddress"  : "london"
              }

Response : {
               "meta": {
                   "statusCode": "200",
                   "statusMessage": "Successfully Profile Created.",
                   "developerMessage": null,
                   "timestamp": "2019-07-19T00:45:02.056"
               }
           }


## Get Complete User Profile (POST)

### With Emailid and OrganizationID (no Login)

URL: localhost:9090/service/user-profile
RequestBody : {
              	"email" : "test2@gmail.com",
              	"organizationId" : "plastic"
              }

Response : {
               "meta": {
                   "statusCode": "200",
                   "statusMessage": "Successful User Info fetched.",
                   "developerMessage": null,
                   "timestamp": "2019-07-19T00:54:20.443"
               },
               "data": {
                   "email": "test2@gmail.com",
                   "userType": "DEALER",
                   "accountActive": true,
                   "profile": {
                       "firstName": "test",
                       "lastName": "jain",
                       "address": "987/H -G plot 6 Delhi",
                       "pincode": "122011",
                       "verifiedProfile": false
                   },
                   "corporateProfile": {
                       "firmName": "testing solutions pvt ltd",
                       "gstin": "AGP21334ASDF564",
                       "aadharNo": "123412341234",
                       "billingAddress": "london",
                       "corporateProfileVerified": false
                   }
               }
           }


### With ssoToken (logged in user)
URL: localhost:9090/service/user-profile
RequestBody : 	{
              		"ssoToken" : "33b016d8-57d8-4cd8-9a12-19281862c3c1"
              	}

Response :  {
                "meta": {
                    "statusCode": "200",
                    "statusMessage": "Successful User Info fetched.",
                    "developerMessage": null,
                    "timestamp": "2019-07-19T00:54:20.443"
                },
                "data": {
                    "email": "test2@gmail.com",
                    "userType": "DEALER",
                    "accountActive": true,
                    "profile": {
                        "firstName": "test",
                        "lastName": "jain",
                        "address": "987/H -G plot 6 Delhi",
                        "pincode": "122011",
                        "verifiedProfile": false
                    },
                    "corporateProfile": {
                        "firmName": "testing solutions pvt ltd",
                        "gstin": "AGP21334ASDF564",
                        "aadharNo": "123412341234",
                        "billingAddress": "london",
                        "corporateProfileVerified": false
                    }
                }
            }
