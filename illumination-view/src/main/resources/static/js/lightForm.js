$(function () {
    console.log("ready!");
    $(".add-more").on("click", clone);
    $(".jq-remove").on("click", remove);
    $(".jq-remove-existed").on("click", removeExisted);
});
function clone() {
    var regex = /^(.+)\[(\d+)\](.+)\[(\d+)\](.+)$/;
    var inputName = $(this).parent().children(".jq-start-to-clone").attr("name");
    var place = $(this).closest(".jq-group");

    var matcher = inputName.match(regex);
    var dayId = parseInt(matcher[2]);
    var prevTimeName =  place.children(".jq-copy").last().children(".jq-start-to-clone").attr("name")
    var timeId =1;
    if(prevTimeName !== undefined)
        timeId =parseInt(prevTimeName.match(regex)[4]) +1;

    console.log("dare");
      var x= $(this).closest(".jq-template").clone().remove(".add-more")
            .append("<button class=\"btn btn-danger jq-remove\" type=\"button\">-</button>")
        .appendTo(place).addClass("jq-copy").find("*").each(function () {
        var name = this.name || "";
        var match = name.match(regex) || [];
        if (match.length === 6) {
            this.name = match[1] + "[" + (dayId) + "]" + match[3] + "[" + timeId + "]" + match[5];
        }
    });
    x.remove(".add-more");
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

function removeExisted() {
    var el =$(this).closest(".jq-copy");
    el.hide().children(".jq-remove-tag").prop('checked', true);

}
function remove() {
    console.log("abc");
    $(this).closest(".jq-copy").remove();
}
