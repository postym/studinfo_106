<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Student;
use App\Models\Course;
use Illuminate\Support\Facades\DB;

class ImportController extends Controller
{
    public function importXml()
    {
        $studentsFilePath = storage_path('app/Student.xml');
        $coursesFilePath = storage_path('app/Course.xml');

        // Check if the files exist
        if (!file_exists($studentsFilePath) || !file_exists($coursesFilePath)) {
            return response()->json(['error' => 'XML files not found.'], 404);
        }

        // Load the XML files
        $studentsXml = simplexml_load_file($studentsFilePath);
        $coursesXml = simplexml_load_file($coursesFilePath);

        DB::transaction(function() use ($studentsXml, $coursesXml) {
            // Import students
            foreach ($studentsXml->student as $student) {
                Student::create([
                    'id' => (int) $student->id,
                    'name' => (string) $student->name,
                    'age' => (int) $student->age,
                    'address' => (string) $student->address,
                    'contact_number' => (string) $student->contact_number,
                ]);
            }

            // Import courses and student_courses
            foreach ($coursesXml->courses as $course) {
                $courseModel = Course::create([
                    'id' => (int) $course->course_id,
                    'title' => (string) $course->course_title,
                    'description' => (string) $course->course_description,
                ]);

                // Attach student to course
                DB::table('student_courses')->insert([
                    'student_id' => (int) $course->student_id,
                    'course_id' => $courseModel->id,
                ]);
            }
        });

        return "XML Data Imported Successfully!";
    }
}
