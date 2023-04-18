# jobapiapp

In this project, the database use is H2 in memory database. it is prepopulate with a user with username:user1 and password:user1pass. The api includes authenticate API to authenticate user and received JWT token from the server, and register API, to register user with its username and password. Registered user will be able to authenticate the account with its username and password.
User can access the API for register and authenticate from these URL:
- `http://localhost:7777/user/register`,
- `http://localhost:7777/user/authenticate`

both API above use the POST method.

to get the data for job list, and job detail for a specific id, user can access the API through the these link with GET method:
- `http://localhost:7777/api/job/{id}`
- `http://localhost:7777/api/jobs`

to access the job list and job api, user must include the `Authorization` key to the header with the jwt token prefixed by `Bearer ` (e.g. `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTY4MTg1NzIzNCwiaWF0IjoxNjgxODM5MjM0fQ.XaiYBY8xK206uDsSOeonliakcOkIM1PJtnJdN-rnvZIlIAaVeKeewiUvDncLIrE7pu-5KEbHBvlfSd1hvJLhqg`.
