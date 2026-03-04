# Digital University System — INFO 5100 Group Assignment

---

## Team Information

| Name | NUID | Role | Branch Owner |
|------|------|------|--------------|
| Polina Starobinets | 002434317 | Administrator | Admin panels, bridge architecture |
| Emmanuel Ould Tayeb | 003185058 | Faculty | Faculty panels, grading |
| Henry (Hank) | 003187730 | Student | Student panels, GPA logic |
| Lanre | 002541742 | Registrar | Registrar panels, reports |

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

**My Profile** (`ViewEditProfileJPanel`) — Loads logged-in faculty's real name, email, phone and office location from `EmployeeProfile`. Department field is read-only (faculty cannot change their own department). Save and Cancel buttons with input validation.

**Manage Courses** (`ViewAssignedCoursesJPanel`) — View all Fall 2025 course offerings in JTable (Course ID, Name, Semester, Capacity, Enrolled). Data pulled live from `business.getDepartment().getCourseSchedule("Fall 2025")` with null check.

**Update Course Details** (`UpdateCourseDetailsJPanel`) — Select course from dropdown → view and edit title, capacity, schedule, description. Real course data pulled from `CourseOffer`.

**Manage Syllabus** (`ManageSyllabusJPanel`) — Select course from dropdown → upload syllabus via URL field. Input validation: URL field cannot be empty before uploading.

**Manage Enrollment** (`ManageEnrollmentJPanel`) — Select course → open or close enrollment. Status label updates dynamically (green = OPEN, red = CLOSED).

**View Enrolled Students** (`ViewEnrolledStudentJPanel`) — Select course from dropdown → see all enrolled students with NUID, name, and current grade. Data pulled via `StudentDirectory.getStudentList()` + `SeatAssignment` bridge to university package.

**Student Progress Report** (`StudentProgressReportJPanel`) — Select student → view name, ID, email, current course, GPA, enrollment count, academic standing. GPA and standing pulled from `Transcript.getOverallGPA()` and `Transcript.getAcademicStanding()`.

**Student Transcript View** (`StudentTranscriptViewJPanel`) — Select student → view full transcript table (Term, Course ID, Course Name, Grade, Credits). GPA displayed via `Transcript.getOverallGPA()`.

**Grade Assignments** (`GradeAssignmentsJPanel`) — Select course → table populates with enrolled students and current grades. Select student row → assign letter grade (A through F). Grade saved to `SeatAssignment.setGrade()` using `GRADE_MAP`. Validation: must select a student row before assigning.

**Student Rankings** (`StudentRankingJPanel`) — Select course → view ranked student table (Rank, Name, Grade %, Letter Grade). Class GPA calculated from average overall GPA of enrolled students.

**Course Performance Report** (`CoursePerformanceJPanel`) — Select course and semester → view grade distribution table (Grade, Count, Percentage). Summary stats: average grade points, enrollment count, class GPA. Data pulled from `SeatAssignment.getGrade()` and `getGradePoints()`.

**Tuition Insight** (`TuitionInsightJPanel`) — Select course → view per-student tuition breakdown (Name, Credits, Tuition, Paid/Pending). Summary: enrollment count, tuition per student, total revenue. Payment status from `StudentProfile.isTuitionPaid()`.


---

### Student (Hank)

**Course Registration** — Students can search for and browse for course offers in a defined semester in a table. Search methods are by Course ID, Teacher Name, and Course name. 

**Enrollment & Drop with Credit Cap** — After selecting a course in the table, the student can either enroll in that course or drop it if already enrolled. Enrollment has a restriction if the student already has 8-credits in the defined semester because the university is enforcing that credit limit per semester. Success/Fail notifications are present. 

**Tuition Management** — 
When a student enrolls in a course, the price of the course is added to the student profile’s tuition balance. In order to pay their balance, the student must first navigate to the Tuition Payment screen. When clicking pay tuition the student gets a yes/no confirmation request, and the student’s balance is updated accordingly. 
Student’s can also drop courses from the Course Registration screen by selecting their enrolled course and clicking the drop button which automatically issues a refund if tuition has already been paid. Null checks are in place in the event a student tries to drop a course they are not enrolled in. 
Success messages are in place upon successful payment and successful refunds. 
All transaction history is stored in the table on Tuition Payment panel 


**Transcript** (locked until tuition paid) — Student’s will find they are unable to review their transcript if they have an outstanding tuition balance per university policy 
Once Student’s balance is fully paid & up to date, only then can they open their transcript (filterable by all semesters or one semester) 
Contents: Term, Academic Standing, Course ID, Course Name, Grade, Term GPA, Overall GPA 


**Academic Standing:**
There are 3 criteria for a student’s academic standing: Good Standing, Academic Warning, or Academic Probation
Good Standing: Term & Overall GPA both >=  3.0
Academic Warning: Term GPA < 3.0
Academic Probation: Overall GPA < 3.0 
New Student: GPA = 0.0 (no grades yet) 


**GPA Calculation** — GPA for a term (semester) and overall (all semesters) are calculated using a grade point scale (HashMap) multiplied by credit hours to produce quality points. Scale (from student’s SeatAssignments): 
1.	A = 4.0
2.	A- = 3.7
3.	B+ = 3.3
4.	B = 3.0
5.	B- = 2.7
6.	C+ = 2.3
7.	C = 2.0
8.	C- = 1.7
9.	F = 0.0


**Graduation Audit** — 	This panel automatically checks students credits versus the graduation credit requirement of 32. Ready for graduation/not ready is displayed

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
- **Navigation wiring:** `FacultyWorkAreaJPanel` buttons were pointing to wrong panels (Admin panels). Fixed by updating all 4 button handlers to load the correct faculty panels and pass `Business` + `CardSequencePanel` objects.
- **Logged-in faculty context:** Faculty panels had no way of knowing who was logged in. Fixed by passing `EmployeeProfile` through the constructor chain: `ProfileWorkAreaMainFrame` → `FacultyWorkAreaJPanel` → `ViewEditProfileJPanel`.
- **Real data integration:** All 12 panels were initially using hardcoded mock data. Replaced with live data calls using `StudentDirectory.getStudentList()`, `getCourseSchedule()`, and `SeatAssignment` bridge to university package.
- **Variable name inconsistencies:** NetBeans-generated variable names (e.g. `cmbSelectStudents` used as a course dropdown) caused confusion when wiring real data. Resolved by checking Navigator panel before implementing each handler.
- **Null safety:** `getCourseSchedule("Fall 2025")` could return null if semester not seeded. Added null checks across all `populateCourseDropdown()` methods to prevent `NullPointerException`.
- **Profile data gap:** Email, phone and office location were not being seeded for faculty. Fixed by adding seed data for all 10 faculty in `ConfigureABusiness.java` and pulling fields from `Profile.java` via `EmployeeProfile`.

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
