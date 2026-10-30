# Supabase setup

Apply `src/main/resources/db/migration/V1__create_initial_schema.sql` in the Supabase SQL Editor.

Configure these environment variables before launching SIAM:
- `SUPABASE_DB_URL`: JDBC PostgreSQL URL with `sslmode=require`
- `SUPABASE_DB_USER`: database username shown in Supabase Connect
- `SUPABASE_DB_PASSWORD`: database password

Use the connection details from the Supabase Dashboard. The URL format is typically `jdbc:postgresql://HOST:5432/postgres?sslmode=require`; if using the session pooler, use its host and username.

Windows PowerShell example:
```powershell
$env:SUPABASE_DB_URL="jdbc:postgresql://HOST:5432/postgres?sslmode=require"
$env:SUPABASE_DB_USER="DATABASE_USER"
$env:SUPABASE_DB_PASSWORD="DATABASE_PASSWORD"
mvn clean package
```

Do not commit real credentials. The Java application does not automatically load env files. The schema is empty; existing MySQL data must be migrated separately. Do not put a Supabase service-role key in the Swing client. Direct JDBC is for controlled development only; a production deployment should use a backend API with restricted database access.
