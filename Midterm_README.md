# Digital University System — INFO 5100 Group Assignment

---

## Team Information

| Name | NUID | Role | Branch Owner |
|------|------|------|--------------|
| Polina Starobinets | 002434317 | Administrator | Admin panels, bridge architecture |
| Emmanuel Ouldtayeb | XXXXXXXX | Faculty | Faculty panels, grading |
| Henry (Hank) | XXXXXXXX | Student | Student panels, GPA logic |
| Lanre | XXXXXXXX | Registrar | Registrar panels, reports |

---

## Project Overview

A role-based university management system built in Java/Swing. Each team member implements a separate role (Admin, Faculty, Student, Registrar) that shares a common data layer. The system enforces authentication and role-based authorization through an Access Control Layer with CardLayout navigation.

---

## Installation & Setup

**Prerequisites:**
- Java 19.0.2 (2023-01-17)
- Apache NetBeans IDE 16
- Git 2.51.0

**Setup Steps:**
1. Clone: `git clone https://github.com/vakhanka/__Midterm_Project_Team-VTL_INFO_5100_Group__`
2. Open NetBeans → File → Open Project → navigate to `Midterm/ProfileWorkAreaExample`
3. Run → Clean and Build, then Run → Run Project

**Login Credentials:**

| Role | Username | Password | Routes To |
|------|----------|----------|-----------|
| Admin | admin | admin123 | AdminRoleWorkAreaJPanel |
| Faculty | faculty1 | password | FacultyWorkAreaJPanel |
| Student | student1 | password | StudentWorkAreaJPanel |
| Registrar | registrar | registrar123 | RegistrarWorkAreaJPanel |

---

## Authentication & Access Control

Login is handled by `UserAccountDirectory.authenticateUser(username, password)`. On success, `ProfileWorkAreaMainFrame` reads the profile type and routes to the correct work area panel.

**Routing logic:** `AdminRoleProfile` → Admin; `EmployeeProfile` with role field → Faculty or Registrar; `StudentProfile` → Student.

| Role | Access Scope |
|------|-------------|
| Administrator | Full system — user accounts, personnel records, analytics |
| Faculty | Own profile, assigned courses, grading, syllabus |
| Student | Own profile, course registration, transcript, tuition |
| Registrar | Enrollment management, course offerings, financial reporting |

---

## Features Implemented

### Administrator (Polina)

**User Account Management**
- View all accounts in searchable JTable (`ManageUserAccountsJPanel`)
- Create accounts with role assignment and auto-generated NUID (`CreateNewUserAccountJPanel`)
- Edit username, email, phone (`AdministerPersonJPanel`); reset passwords; delete accounts
- View metadata: created date

**Personnel Management**
- Manage student records — search by name, NUID, or department (`ManageStudentsJPanel`)
- Manage faculty records — search by name, NUID, or department (`ManageFacultyJPanel`)
- Manage employee/registrar records (`ManageEmployeesJPanel`)
- Edit registrar office hours (`AdministerRegistrarJPanel`), student details (`AdministerStudentJPanel`), faculty details (`AdministerFacultyJPanel`)

**Analytics Dashboard** (`AnalyticsJPanel`)
- Total active users by role
- Total courses offered per semester
- Total enrolled students per course
- Tuition revenue summary by semester

**My Profile** — View and edit own admin profile (`AdminMyProfile`)

---

### Faculty (Emmanuel)

**My Profile** (`ViewEditProfileJPanel`) — View and edit: name, email, department, phone, office hours

**Manage Courses** (`ViewAssignedCoursesJPanel`) — View all Fall 2025 offerings in JTable (Course ID, Name, Semester, Capacity, Enrolled). Data pulled live from `department.getCourseSchedule()`.

**View Enrolled Students** (`ViewEnrolledStudentJPanel`) — Select course from dropdown → see enrolled students with name, NUID, current grade. Data pulled live via bridge from `StudentProfile.getUniversityProfile()`.

**Update Course Details** (`UpdateCourseDetailsJPanel`) — Select course → view/edit title, capacity, schedule, description.

**Manage Syllabus** (`ManageSyllabusJPanel`) — Select course from dropdown → upload syllabus via URL field.

**Grade Assignments** (`GradeAssignmentsJPanel`) — Select course and student → assign letter grade (A through F).
> ⚠️ Student list uses mock data; grade persistence not yet wired to model.

**Course Performance** (`CoursePerformanceJPanel`) — View grade distribution table and summary stats (avg GPA, enrollment, class grade).
> ⚠️ Uses mock/hardcoded data; not yet wired to live SeatAssignment grades.

---

### Student (Hank)

**Course Registration** — Browse all available offerings in JTable. Three search methods via dropdown: Course ID, Teacher Name, Course Name.

**Enrollment & Drop with Credit Cap** — Enroll/drop courses; enrollment blocked if exceeding 8-credit-hour-per-semester limit.

**Tuition Management** — Enrollment auto-adds course price to balance. Pay via Tuition Payment panel. If balance is $0 or negative: dialog shown, no action, no history entry. Dropping after payment triggers automatic refund. Full payment history maintained.

**Transcript** (locked until tuition paid) — Filterable by semester dropdown. Columns: Term, Standing, Course ID, Name, Grade, Term GPA, Overall GPA.

**Academic Standing:**
- Good Standing: Term GPA ≥ 3.0 and Overall GPA ≥ 3.0
- Academic Warning: Term GPA < 3.0
- Academic Probation: Overall GPA < 3.0

**GPA Calculation** — Standard scale (A=4.0, A−=3.7, B+=3.3 … F=0.0); quality points = grade points × credit hours.

**Graduation Audit** — Auto-checks: 32 total credit hours + INFO 5100 core course; displays readiness.

**Infrastructure Contributions (university package):**
- `SeatAssignment.java` — grade field, static `GRADE_MAP`, `getGradePoints()`
- `Transcript.java` — `getSemesterGPA()`, `getOverallGPA()`, `getAcademicStanding()`
- `CourseLoad.java` — `getTotalCredits()`, delegating `getSemesterGPA()`
- `StudentProfile.java` (univ.) — balance field, `pay()`, `refund()`, `isTuitionPaid()`, `paymentHistory`

---

### Registrar (Lanre)

**Registrar Dashboard** (`RegistrarWorkAreaJPanel`) — Dedicated UI with CardLayout navigation, separated from other role views.

**Course Offering Management** (`ManageCourseOfferingsJPanel`) — Create semester offerings, assign faculty, set capacity, update room/time. Capacity validation: cannot reduce below current enrollment. Faculty dropdown shows full names.

**Admin-Side Student Registration** (`StudentRegistrationJPanel`) — Load semester offerings, enroll student (duplicate + capacity checks), drop with seat release. Student and faculty dropdowns display full names.

**Manage Own Profile** — View/edit contact info and office hours; changes persist within session.

**Tuition & Financial Reconciliation** (`TuitionAndFinancialJPanel`) — Filter by department and semester; display tuition status (Paid/Balance). Reports: Total Collected, Unpaid Summary, Department Revenue Breakdown. Transcript visibility blocked if balance unpaid; refund logic on course drop.

**Reporting & Analytics** (`ReportingAndAnalyticsJPanel`) — Enrollment by department/course; GPA distribution (bucketed). Dynamic JTable model switching; semester filters; clean Back navigation.

---

## Usage Instructions

### Admin Scenarios

- **Create a new user account:** Login as admin/admin123 → Administer User Accounts → Create New Account → Enter name, role, email, phone → System auto-generates NUID → Set username/password → Save.
- **Edit an account:** Administer User Accounts → Select row → Next → Update fields → Save (or Reset Password).
- **Search for a student:** Manage Students → Search by Name (partial), NUID (exact), or Department → Select → Edit.
- **View analytics:** Click Analytics Dashboard → Four summary tables load automatically.

### Faculty Scenarios

- **View assigned courses:** Login as faculty1/password → Manage Courses → Table loads Fall 2025 offerings.
- **View enrolled students:** Manage Student Profiles → View Enrolled Students → Select course from dropdown.
- **Upload syllabus:** Manage Courses → Manage Syllabus → Select course → Enter URL → Upload.
- **Assign a grade:** Manage Courses → Grade Assignments → Select course and student → Choose grade → Assign.

### Student Scenarios

- **Search and enroll:** Login as student1/password → Course Registration → Select search type → Type keyword → Search → Select course → Enroll. Error shown if exceeding 8 credits.
- **Drop a course:** Course Registration → Select enrolled course → Drop. Auto-refund if tuition already paid.
- **Pay tuition:** Tuition Payment → View balance and history → Click Pay. Dialog shown if balance is already $0.
- **View transcript:** Transcript (blocked until tuition paid) → Use semester dropdown to filter.
- **Graduation audit:** Click Graduation Audit → Auto-evaluates 32 credits + INFO 5100 requirement.

### Registrar Scenarios

- **Create offering:** Login as registrar/registrar123 → Select Department → Semester → Load → Create Offering → Assign Faculty → Set Capacity/Room/Time → Save.
- **Enroll/drop student:** Select Student → Department → Semester → Load → Enroll or Drop.
- **Financial monitoring:** Select Department → Semester → Load → Generate Report.
- **Analytics:** Select filters → Choose report type → View results in JTable.

---

## Testing Guide

### Authentication Tests

| Test Case | Steps | Expected Result |
|-----------|-------|-----------------|
| Valid admin login | Enter admin / admin123 → Login | Routes to Admin work area |
| Valid student login | Enter student1 / password → Login | Student Work Area loads |
| Invalid credentials | Enter wrong password → Login | Error message, no navigation |
| Duplicate username | Create account with existing username | Validation error displayed |

### Student-Specific Tests

| Test Case | Steps | Expected Result |
|-----------|-------|-----------------|
| Enroll within cap | Select course ≤ 8 credits → Enroll | Success; balance updated |
| Enroll over cap | Select course pushing > 8 credits | Error: exceeds 8-credit limit |
| Transcript locked | Navigate to Transcript before paying | Access blocked; pay prompt |
| Drop after payment | Pay tuition, then drop course | Refund credited back |
| Graduation — not ready | Student < 32 credits or missing INFO 5100 | "Not Ready to Graduate" |
| Graduation — ready | Student ≥ 32 credits including INFO 5100 | "Ready to Graduate" |

### Registrar-Specific Tests

| Test Case | Steps | Expected Result |
|-----------|-------|-----------------|
| Create offering | Create new offering → assign faculty | Offering appears in table |
| Reduce capacity below enrollment | Set capacity < current enrolled | Prevented by validation |
| Duplicate enrollment | Enroll same student twice | Blocked |
| Revenue report | Generate total revenue summary | Correct totals displayed |

---

## Challenges & Solutions

### Polina (Admin)
- **Bridge pattern:** Business and university packages had separate profile classes. Solved by adding `linkUniversityProfile()` / `getUniversityProfile()` and wiring during seeding.
- **Multi-department architecture:** System was hardcoded to one department. Added `departmentName` field, updated seeding for IS and CS, implemented department-based search.
- **ID mismatch:** Business side used auto-generated NUIDs while university side used names as IDs. Fixed by aligning IDs during seeding.
- **Login routing:** All EmployeeProfile users routed to Admin. Fixed by adding role field and checking it in `ProfileWorkAreaMainFrame`.

### Emmanuel (Faculty)
> *To be completed by Emmanuel.*

### Hank (Student)
- **Data type mismatch:** Teammate updates to shared class field types broke compile without Git conflict flags. Required re-reading updated files and adjusting method calls.
- **Null pointer exceptions:** Tuition balance not persisting because panels instantiated separate object copies. Fixed by tracing references and ensuring shared `StudentProfile` instance.
- **Transcript lock logic:** "Paid" had to mean balance ≤ 0 accounting for refunds. Centralized `isTuitionPaid()` in `StudentProfile` rather than embedding in UI.
- **Branch coordination:** Successful merges sometimes broke panels at runtime. Learned to pull and clean build after every teammate's PR merge.

### Lanre (Registrar)
- **Business/University ID mismatch:** Implemented ID mapping via `PersonDirectory` lookup.
- **JTable showing IDs:** Added custom renderers and helper mapping methods to display names.
- **ComboBox clearing:** Solved with stable `DefaultComboBoxModel` replacement.
- **Capacity validation:** Added increase-only seat logic to preserve enrollment integrity.
- **Cross-layer dependencies:** Used fully qualified package references to avoid import conflicts.

---

## Contribution Breakdown

| Member | Coding | Documentation | Testing | Other |
|--------|--------|---------------|---------|-------|
| Polina | Admin UI, bridge architecture, seeding fixes, multi-dept support | README (Admin sections) | Admin flow | WBS, GitHub Projects |
| Emmanuel | Faculty panels, course mgmt, grading, syllabus, performance | README (Faculty sections) | Faculty flow | |
| Hank | Student panels, GPA logic, tuition, transcript, graduation audit | README (Student sections), Testing Guide | Student flow | University pkg extensions |
| Lanre | Registrar panels, offerings, enrollment, financial, analytics | README (Registrar sections) | Registrar flow | Name rendering, data seeding |

---

## Future Enhancements

- Export reports to PDF/CSV
- Add charts for analytics (bar and pie graphs)
- Multi-semester comparison view
- Advanced filtering options
- Real-time tuition dashboard

---

## Project Status

| Check | Status |
|-------|--------|
| Fully functional | Complete |
| Merged into main branch | Complete |
| No runtime errors | Complete |
| Role-based access enforced | Complete |
| Ready for presentation | Complete |

---

*INFO 5100 — Application Engineering & Development | Northeastern University*
