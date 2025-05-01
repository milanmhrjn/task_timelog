A REST API for managing personal productivity. This system allows users to create tasks, log time spent on them, and track their productivity.

Features
Task Management: Create tasks, update task status, and track task progress.

Time Logging: Log time spent on tasks, and view time logs with start and end timestamps.

Productivity Tracking: Get total time spent on each task.

Entities
Task
id (auto-generated) - Unique identifier for the task.

title - The title of the task.

description - A detailed description of the task.

status (Enum) - The current status of the task. Possible values:

PENDING

IN_PROGRESS

COMPLETED

createdAt - Timestamp of when the task was created.

updatedAt - Timestamp of the last update to the task.

TimeLog
id (auto-generated) - Unique identifier for the time log.

task_id (foreign key) - The ID of the task to which this time log is related.

startTime - Timestamp indicating when the task was started.

endTime - Timestamp indicating when the task was finished.
