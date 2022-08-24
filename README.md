#### GET /api/departments/
RESPONSE
```json
{
    "status": "success",
    "data": [
        {
            "departmentId": 1,
            "deptName": "Phong 1",
            "desciption": "Phong so 1",
            "employees": [
                {
                    "employeeId": 3,
                    "name": "Nhan vien 1",
                    "birthDate": "2001-01-01",
                    "gender": "Nam"
                },
                {
                    "employeeId": 4,
                    "name": "Nhan vien 2",
                    "birthDate": "2002-01-01",
                    "gender": "Nu"
                }
            ]
        },
        {
            "departmentId": 2,
            "deptName": "Phong 2",
            "desciption": "Phong so 2",
            "employees": []
        }
    ],
    "message": null
}
```
---

#### GET /api/departments/3
RESPONSE
```json
{
    "status": "error",
    "data": null,
    "message": "Not found department with id = 3"
}
```
---

#### DELETE /api/departments/2
RESPONSE
```json
{
  "status": "success",
  "data": null,
  "message": null
}
```
---

#### POST /api/departments/
REQUEST
```json
{
"deptName": "Phong 3",
"desciption": "Phong so 3"
}
```

RESPONSE
```json
{
  "status": "success",
  "data": {
    "departmentId": 5,
    "deptName": "Phong 3",
    "desciption": "Phong so 3",
    "employees": null
  },
  "message": null
}
```
---

#### GET /api/employees/
RESPONSE
```json
{
    "status": "success",
    "data": [
        {
            "employeeId": 3,
            "name": "Nhan vien 1",
            "birthDate": "2001-01-01",
            "gender": "Nam",
            "departmentId": 1
        },
        {
            "employeeId": 4,
            "name": "Nhan vien 2",
            "birthDate": "2002-01-01",
            "gender": "Nu",
            "departmentId": 1
        }
    ],
    "message": null
}
```
---

#### GET /api/employees/3
RESPONSE
```json
{
    "status": "success",
    "data": {
        "employeeId": 3,
        "name": "Nhan vien 1",
        "birthDate": "2001-01-01",
        "gender": "Nam",
        "departmentId": 1
    },
    "message": null
}
```
---

#### DELETE /api/employees/1
RESPONSE
```json
{
    "status": "error",
    "data": null,
    "message": "Not found employee with id = 1"
}
```
---
#### POST /api/employees/
REQUEST
```json
{
    "name": "Nhan vien 3",
    "birthDate": "2002-01-01",
    "gender": "Nu",
    "departmentId": 10
}
```

RESPONSE
```json
{
    "status": "error",
    "data": null,
    "message": "Not found department with id = 10"
}
```



