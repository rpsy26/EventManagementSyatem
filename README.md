### Create Event

##### Request URL:
```
localhost:8080/event/create
```
##### Request:
````
{
    "eventName":"Music Concert",
    "speaker":"AR Rehman",
    "venue":"Gurgaon",
    "startDate":"03-10-2020"
}
````
##### Response:
````
Successfully added event Music Concert
````
### Register User for Event

##### Request URL
````
localhost:8080/user/register
````
##### Request:
````
{
   "userName":"Rahul",
   "eventID":1
}
````
##### Response:
````
Successfully added user:  Rahul
````
### Fetch event between two dates

##### Request URL
````
localhost:8080/event/fetch
````
##### Request:
````
{
    "startDate":"2020-10-01",
    "endDate":"2020-10-05",
    "venue":"Gurgaon"
}
````
##### Response:
````
{
    "2020-10-03": [
        {
            "id": 1,
            "eventName": "Music Concert",
            "speaker": "AR Rehman",
            "venue": "Gurgaon",
            "numUsers": 1,
            "startDate": "03-10-2020"
        }
    ]
}
````