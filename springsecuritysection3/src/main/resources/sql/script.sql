create table users(username varchar(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
create table authorities (username varchar (50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);



-- Create Users

INSERT IGNORE INTO USERS VALUES ('USER', '{noop}Auto@2024','1');
INSERT INTO AUTHORITIES VALUES ('USER', 'read');


INSERT IGNORE INTO USERS VALUES ('admin', '{bcrypt}$2a$12$tA6MLvnzJRi9KYidaIsxpurGUeHcOe6dl1SJY4qK6LCdgmowNFicK','1');
INSERT INTO AUTHORITIES VALUES ('admin', 'admin')


-- Create Customer

CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50),
    zip_code VARCHAR(10),
    country VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    account_creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    account_status ENUM('Active', 'Inactive', 'Suspended') DEFAULT 'Active',
    loyalty_points INT DEFAULT 0,
    preferred_contact_method ENUM('Email', 'Phone', 'SMS'),
    marketing_opt_in BOOLEAN DEFAULT FALSE,
    customer_access varchar (90) not null,
    customer_type varchar (90) not null,
    referral_code VARCHAR(20)
);

-- Inster Customer Scripts





use eazybank;

INSERT INTO  Customer (
    customer_name,
    phone_number,
    address,
    city,
    state,
    zip_code,
    country,
    email,
    username,
    password,
    date_of_birth,
    gender,
    account_creation_date,
    last_login,
    account_status,
    loyalty_points,
    preferred_contact_method,
    marketing_opt_in,
    customer_access,
    customer_type,


    referral_code
) VALUES
(
    'Sran Kumar',
    '+916383085842',
    'No 19, Krishna nagar, 3rd Street, kolathur',
    'chennai',
    'TamilNadu',
    '60099',
    'India',
    'sarankumar.studies@gamil.com',
    'saran_jr',
    '{noop}Studies@123',        -- Replace with hashed password in production
    '1985-06-15',
    'Male',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    'Active',
    120,
    'Email',
    TRUE,
    'read',
    'normal',
    'REF12345'

),
(
    'Jane Smith',
    '+0987654321',
    '456 Oak Avenue',
    'Metropolis',
    'California',
    '90210',
    'USA',
    'sneka.k@gmail.com',
    'sneka_kannan',
    '{bcrypt}$2a$12$ddcXywq1unYlxlsy/Krkvex6FEJO6c1t6uu.SjR0bCF8sZ.rRv.8G',    -- Replace with hashed password in production
    '1990-03-22',
    'Female',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    'Active',
    200,
    'Phone',
    FALSE,
    'read',
    'normal',
    'REF67890'
);

