
$('.table #deleteButton').on('click', function(event) {
    event.preventDefault();
    var href = $(this).attr('href');
    $('#deleteModal #delHref').attr('href', href);
    $('#deleteModal').modal();
});