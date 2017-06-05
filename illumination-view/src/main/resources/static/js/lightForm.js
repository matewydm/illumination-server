$(function () {
    console.log("ready!");
    $(".add-more").on("click", clone);
    $(".jq-remove").on("click", remove);
});
function clone() {
    var regex = /^(.+)\[(\d+)\](.+)\[(\d+)\](.+)$/;
    var inputName = $(this).parent().children(".jq-copy-time").last().find(".jq-start-to-clone").attr("name");

    if (inputName === undefined) {
        inputName =$(this).parent().children(".jq-to-clone").find(".jq-start-to-clone").attr("name");
    }
    var matcher = inputName.match(regex);
    var dayId = parseInt(matcher[2]);
    var timeId = parseInt(matcher[4]) + 1;
    console.log("dare");
    var place = $(this).closest(".jq-day-group");
        $(this).closest(".jq-day-group").children(".jq-to-clone").clone()
            .append("<button class=\"btn btn-danger jq-remove\" type=\"button\">-</button>")
        .appendTo(place).wrap("<div class='form-group jq-copy-time'></div>").find("*").each(function () {
        var name = this.name || "";
        var match = name.match(regex) || [];
        if (match.length === 6) {
            this.name = match[1] + "[" + (dayId) + "]" + match[3] + "[" + timeId + "]" + match[5];
        }
    });
    $(".jq-remove").on("click", remove);

    //     .attr("id", "clonedInput" +  cloneIndex)
    //     .find("*")
    //     .each(function() {
    //         var id = this.id || "";
    //         var match = id.match(regex) || [];
    //         if (match.length == 3) {
    //             this.id = match[1] + (cloneIndex);
    //         }
    //     })
    //     .on('click', 'button.clone', clone)
    //     .on('click', 'button.remove', remove);
    // cloneIndex++;
}

function remove() {
    console.log("abc");
    $(this).closest(".jq-copy-time").remove();
}
