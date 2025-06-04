INSERT INTO full_names (first_name, last_name, patronymic) VALUES
('Иван', 'Иванов', 'Иванович'),
('Петр', 'Петров', 'Петрович'),
('Сергей', 'Сергеев', 'Сергеевич'),
('Анна', 'Сидорова', 'Владимировна'),
('Мария', 'Кузнецова', 'Алексеевна'),
('Алексей', 'Смирнов', 'Дмитриевич'),
('Елена', 'Попова', 'Олеговна'),
('Дмитрий', 'Васильев', 'Игоревич'),
('Ольга', 'Новикова', 'Сергеевна'),
('Николай', 'Федоров', 'Николаевич');

INSERT INTO job_titles (name, description) VALUES
('Разработчик', 'Разработка программного обеспечения'),
('Тестировщик', 'Тестирование программного обеспечения'),
('Аналитик', 'Анализ требований и проектирование систем'),
('Менеджер проектов', 'Управление проектами и командами'),
('Дизайнер', 'Дизайн пользовательских интерфейсов'),
('DevOps-инженер', 'Настройка инфраструктуры и CI/CD'),
('Технический писатель', 'Написание технической документации'),
('Системный администратор', 'Обслуживание IT-инфраструктуры'),
('Руководитель отдела', 'Управление отделом разработки'),
('Специалист по безопасности', 'Обеспечение информационной безопасности');

INSERT INTO qualifications (name, job_title_id) VALUES
('Junior Developer', (SELECT id FROM job_titles WHERE name = 'Разработчик')),
('Middle Developer', (SELECT id FROM job_titles WHERE name = 'Разработчик')),
('Senior Developer', (SELECT id FROM job_titles WHERE name = 'Разработчик')),
('QA Engineer', (SELECT id FROM job_titles WHERE name = 'Тестировщик')),
('Lead QA', (SELECT id FROM job_titles WHERE name = 'Тестировщик')),
('Business Analyst', (SELECT id FROM job_titles WHERE name = 'Аналитик')),
('Project Manager', (SELECT id FROM job_titles WHERE name = 'Менеджер проектов')),
('UI/UX Designer', (SELECT id FROM job_titles WHERE name = 'Дизайнер')),
('DevOps Engineer', (SELECT id FROM job_titles WHERE name = 'DevOps-инженер')),
('Technical Writer', (SELECT id FROM job_titles WHERE name = 'Технический писатель'));

INSERT INTO roles (name) VALUES
('ROLE_ADMIN'),
('ROLE_MANAGER'),
('ROLE_EMPLOYEE');

INSERT INTO employees (login, email, password, full_name_id, qualification_id) VALUES
('manager1', 'manager1@company.com', '$2a$10$xJwL5v5Jz5U5Z5U5Z5U5Z.5U5Z5U5Z5U5Z5U5Z5U5Z5U5Z5U5Z5U5',
 (SELECT id FROM full_names WHERE first_name = 'Петр' AND last_name = 'Петров'),
 (SELECT id FROM qualifications WHERE name = 'Project Manager')),

('dev1', 'dev1@company.com', '$2a$10$xJwL5v5Jz5U5Z5U5Z5U5Z.5U5Z5U5Z5U5Z5U5Z5U5Z5U5Z5U5Z5U5',
 (SELECT id FROM full_names WHERE first_name = 'Сергей' AND last_name = 'Сергеев'),
 (SELECT id FROM qualifications WHERE name = 'Middle Developer')),

('tester1', 'tester1@company.com', '$2a$10$xJwL5v5Jz5U5Z5U5Z5U5Z.5U5Z5U5Z5U5Z5U5Z5U5Z5U5Z5U5Z5U5',
 (SELECT id FROM full_names WHERE first_name = 'Анна' AND last_name = 'Сидорова'),
 (SELECT id FROM qualifications WHERE name = 'QA Engineer')),

('analyst1', 'analyst1@company.com', '$2a$10$xJwL5v5Jz5U5Z5U5Z5U5Z.5U5Z5U5Z5U5Z5U5Z5U5Z5U5Z5U5Z5U5',
 (SELECT id FROM full_names WHERE first_name = 'Мария' AND last_name = 'Кузнецова'),
 (SELECT id FROM qualifications WHERE name = 'Business Analyst'));

INSERT INTO employee_roles (employee_id, role_id) VALUES
((SELECT id FROM employees WHERE login = 'manager1'), (SELECT id FROM roles WHERE name = 'ROLE_MANAGER')),
((SELECT id FROM employees WHERE login = 'dev1'), (SELECT id FROM roles WHERE name = 'ROLE_EMPLOYEE')),
((SELECT id FROM employees WHERE login = 'tester1'), (SELECT id FROM roles WHERE name = 'ROLE_EMPLOYEE')),
((SELECT id FROM employees WHERE login = 'analyst1'), (SELECT id FROM roles WHERE name = 'ROLE_EMPLOYEE'));

INSERT INTO personal_employees_data (employee_id, phone_number, passport_number, passport_series, date_of_employment) VALUES
((SELECT id FROM employees WHERE login = 'manager1'), '+79162345678', 234567, 2345, '2020-03-20'),
((SELECT id FROM employees WHERE login = 'dev1'), '+79163456789', 345678, 3456, '2021-05-10'),
((SELECT id FROM employees WHERE login = 'tester1'), '+79164567890', 456789, 4567, '2021-07-25'),
((SELECT id FROM employees WHERE login = 'analyst1'), '+79165678901', 567890, 5678, '2022-02-01');

INSERT INTO points (total, last_update, employee_id) VALUES
(1200, '2023-10-01', (SELECT id FROM employees WHERE login = 'manager1')),
(900, '2023-10-01', (SELECT id FROM employees WHERE login = 'dev1')),
(800, '2023-10-01', (SELECT id FROM employees WHERE login = 'tester1')),
(1000, '2023-10-01', (SELECT id FROM employees WHERE login = 'analyst1'));

INSERT INTO task_categories (name, description) VALUES
('Разработка', 'Задачи по разработке нового функционала'),
('Тестирование', 'Задачи по тестированию приложения'),
('Аналитика', 'Задачи по анализу требований и проектированию'),
('Документация', 'Задачи по написанию документации'),
('Исправление ошибок', 'Задачи по исправлению обнаруженных ошибок'),
('Оптимизация', 'Задачи по оптимизации производительности'),
('Инфраструктура', 'Задачи по настройке инфраструктуры'),
('Дизайн', 'Задачи по проектированию пользовательских интерфейсов'),
('Безопасность', 'Задачи по обеспечению безопасности приложения'),
('Поддержка', 'Задачи по поддержке существующего функционала');

INSERT INTO tasks (name, description, number_of_points, deadline, publication_time, status, task_category_id) VALUES
('Реализация авторизации', 'Реализовать систему авторизации пользователей', 100, '2023-10-15', '2023-10-01 09:00:00', 'FREE', (SELECT id FROM task_categories WHERE name = 'Разработка')),
('Тестирование API', 'Провести тестирование REST API', 80, '2023-10-12', '2023-10-01 09:30:00', 'FREE', (SELECT id FROM task_categories WHERE name = 'Тестирование')),
('Анализ требований', 'Проанализировать требования к новому модулю', 70, '2023-10-10', '2023-10-01 10:00:00', 'FREE', (SELECT id FROM task_categories WHERE name = 'Аналитика')),
('Документирование API', 'Написать документацию для REST API', 60, '2023-10-14', '2023-10-01 10:30:00', 'FREE', (SELECT id FROM task_categories WHERE name = 'Документация')),
('Исправить баг #123', 'Исправить ошибку при загрузке файлов', 50, '2023-10-08', '2023-10-01 11:00:00', 'FREE', (SELECT id FROM task_categories WHERE name = 'Исправление ошибок'));

INSERT INTO employee_tasks (employee_id, task_id, execution_status) VALUES
((SELECT id FROM employees WHERE login = 'dev1'), (SELECT id FROM tasks WHERE name = 'Реализация авторизации'), 'IN_PROGRESS'),
((SELECT id FROM employees WHERE login = 'tester1'), (SELECT id FROM tasks WHERE name = 'Тестирование API'), 'IN_PROGRESS'),
((SELECT id FROM employees WHERE login = 'analyst1'), (SELECT id FROM tasks WHERE name = 'Анализ требований'), 'IN_PROGRESS');

INSERT INTO qualification_level_for_task (qualification_id, task_id) VALUES
((SELECT id FROM qualifications WHERE name = 'Middle Developer'), (SELECT id FROM tasks WHERE name = 'Реализация авторизации')),
((SELECT id FROM qualifications WHERE name = 'QA Engineer'), (SELECT id FROM tasks WHERE name = 'Тестирование API')),
((SELECT id FROM qualifications WHERE name = 'Business Analyst'), (SELECT id FROM tasks WHERE name = 'Анализ требований'));

INSERT INTO requests (is_accepted, task_id, employee_id, appointor_id) VALUES
(true, (SELECT id FROM tasks WHERE name = 'Реализация авторизации'), (SELECT id FROM employees WHERE login = 'dev1'), (SELECT id FROM employees WHERE login = 'manager1')),
(true, (SELECT id FROM tasks WHERE name = 'Тестирование API'), (SELECT id FROM employees WHERE login = 'tester1'), (SELECT id FROM employees WHERE login = 'manager1')),
(false, (SELECT id FROM tasks WHERE name = 'Документирование API'), (SELECT id FROM employees WHERE login = 'dev1'), (SELECT id FROM employees WHERE login = 'manager1'));

INSERT INTO task_comments (comment, date_of_writing, employee_id, task_id) VALUES
('Начал работу над авторизацией', '2023-10-02 10:00:00', (SELECT id FROM employees WHERE login = 'dev1'), (SELECT id FROM tasks WHERE name = 'Реализация авторизации')),
('Есть вопросы по требованиям', '2023-10-02 11:30:00', (SELECT id FROM employees WHERE login = 'analyst1'), (SELECT id FROM tasks WHERE name = 'Анализ требований')),
('API тестируется успешно', '2023-10-03 09:45:00', (SELECT id FROM employees WHERE login = 'tester1'), (SELECT id FROM tasks WHERE name = 'Тестирование API'));

INSERT INTO task_execution_requests (employee_id, task_id, is_accepted) VALUES
((SELECT id FROM employees WHERE login = 'dev1'), (SELECT id FROM tasks WHERE name = 'Исправить баг #123'), true),
((SELECT id FROM employees WHERE login = 'tester1'), (SELECT id FROM tasks WHERE name = 'Документирование API'), false);
