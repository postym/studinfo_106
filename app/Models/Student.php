<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Student extends Model
{
    protected $fillable = ['name', 'age', 'address', 'contact_number'];

    public $timestamps = false; // Disable timestamps

    public function courses()
    {
        return $this->belongsToMany(Course::class, 'student_courses');
    }
}
