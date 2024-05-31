<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Course extends Model
{
    protected $fillable = ['title', 'description'];

    public $timestamps = false; // Disable timestamps

    public function students()
    {
        return $this->belongsToMany(Student::class, 'student_courses');
    }
}
