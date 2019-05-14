<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='css/fullcalendar.css' rel='stylesheet' />
<link href='css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='js/moment.min.js'></script>
<script src='js/jquery-1.12.1.js'></script>
<script src='js/fullcalendar.js'></script>
<script>

  $(document).ready(function() {

    $('#calendar').fullCalendar({
      defaultDate: '2019-01-01',
      editable: true,
      eventLimit: true, // allow "more" link when too many events
      events: [
        {
          title: '小红过生日',
          start: '2019-01-01'
        },
        {
          title: '和小王一起上自习',
          start: '2019-01-08',
          end: '2019-01-10'
        },
        {
          id: 999,
          title: '和小丽出去约会',
          start: '2019-01-21T16:00:00'
        },
        {
          id: 999,
          title: '和小丽出去约会',
          start: '2019-01-28T16:00:00'
        },
        {
          title: '与胖子一起去开会',
          start: '2019-01-18',
          end: '2019-01-19'
        },
        {
          title: '与同学一起玩游戏',
          start: '2019-01-05'
        },
        {
          title: '跟好友出去玩耍',
          start: '2019-01-31'
        }
      ]
    });

  });

</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }

</style>
</head>
<body>

  <div id='calendar'></div>

</body>
</html>
