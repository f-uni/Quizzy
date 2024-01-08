<script>
var source = new EventSource("/partita");
source.onmessage = function(event) {
  console.log("Received event: " + event.data);
}
</script>
