-- Таблица: task_categories
CREATE TABLE task_categories (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) UNIQUE,
    description VARCHAR(255)
);

-- Таблица: tasks
CREATE TABLE tasks (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255),
    description TEXT,
    number_of_points INT,
    deadline DATE,
    publication_time TIMESTAMP,
    status VARCHAR(50),
    task_category_id UUID,
    CONSTRAINT fk_task_category FOREIGN KEY (task_category_id) REFERENCES task_categories(id)
);

-- Таблица: employee_tasks
CREATE TABLE employee_tasks (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    employee_id UUID,
    task_id UUID,
    execution_status VARCHAR(50) DEFAULT 'IN_PROGRESS',
    CONSTRAINT fk_employee_tasks_employee FOREIGN KEY (employee_id) REFERENCES employees(id),
    CONSTRAINT fk_employee_task_task FOREIGN KEY (task_id) REFERENCES tasks(id)
);

-- Таблица: qualification_level_for_task
CREATE TABLE qualification_level_for_task (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    qualification_id UUID,
    task_id UUID,
    CONSTRAINT fk_qual_for_task_qualification FOREIGN KEY (qualification_id) REFERENCES qualifications(id),
    CONSTRAINT fk_qual_for_task_task FOREIGN KEY (task_id) REFERENCES tasks(id)
);

-- Таблица: requests
CREATE TABLE requests (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    is_accepted BOOLEAN,
    task_id UUID,
    employee_id UUID,
    appointor_id UUID,
    CONSTRAINT fk_request_task FOREIGN KEY (task_id) REFERENCES tasks(id),
    CONSTRAINT fk_request_employee FOREIGN KEY (employee_id) REFERENCES employees(id),
    CONSTRAINT fk_request_appointor FOREIGN KEY (appointor_id) REFERENCES employees(id)
);

CREATE TABLE task_comments (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    comment TEXT,
    date_of_writing TIMESTAMP,
    employee_id UUID,
    task_id UUID,
    CONSTRAINT fk_task_comment_employee FOREIGN KEY (employee_id) REFERENCES employees(id),
    CONSTRAINT fk_task_comment_task FOREIGN KEY (task_id) REFERENCES tasks(id)
);
