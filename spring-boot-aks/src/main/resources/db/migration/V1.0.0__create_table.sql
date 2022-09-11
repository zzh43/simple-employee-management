CREATE TABLE employee (
    id          integer       IDENTITY(1,1)   PRIMARY KEY,
    last_name   nvarchar(10),
    first_name  nvarchar(10),
    full_name   nvarchar(10),
    description nvarchar(10)
);
