<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\StudentController;
use App\Http\Controllers\ImportController;

Route::get('/', function () {
    return view('welcome');
});

// Route::get('/import', function () {
//     return view('import');
// });

Route::get('/import-xml', [ImportController::class, 'importXml']);
Route::get('/students', [StudentController::class, 'index']);
Route::get('/students/{id}/courses', [StudentController::class, 'showCourses'])->name('students.courses');