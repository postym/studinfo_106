<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Import XML</title>
</head>
<body>
    <h1>Import XML File</h1>

    <form action="/import-xml" method="GET" enctype="multipart/form-data">
        @csrf
        <input type="file" name="xml_file" required>
        <button type="submit">Import</button>
    </form>
</body>
</html>
