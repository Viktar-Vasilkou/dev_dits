 -- select login as username, password, true from users;
 
 SELECT users.login as username, roles.name as role 
        FROM users 
        INNER JOIN userrole ON users.id = userrole.userId 
        INNER JOIN roles ON userrole.roleId = roles.id
        WHERE users.name = ?  