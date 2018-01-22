
function addfields() {
    var p = d.createElement('details');
    var countDataSets = d.getElementById("nitems").value;
    var countMembers = d.getElementById("nmembers").value;
    var html='';
   // p.innerHTML=' <summary>Item for promote</summary>';
    html+='<summary>Item for promote</summary>'+
        '<div class="select-group" style="margin-bottom: 10px;">' +
    '                <select name="items['+countMain+'].name" class="form-control"/ style="margin-top: 10px;">' +
    '<option>Promote</option>'+
    '<option>Compilation</option>'+
    '</select>'+
    '            </div>';
    for(var i=0;i<countDataSets;i++)
    {
        html+='' +
        '            <br/><div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Source dataset</span>' +
        '                <input  name="items['+countMain+'].dataSets['+i+'].itemValue" type="text" class="form-control"/>' +
        '            </div>' +
        '            <div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Target dataset</span>' +
        '                <input name="items['+countMain+'].dataSets['+i+'].itemRemark" type="text" class="form-control"/>' +
        '            </div>';
        for(var j=0; j<countMembers; j++)
        {
            html+=' <div class="input-group" style="margin-bottom: 10px;">' +
                '                     <span class="input-group-addon">Member</span>' +
                '                     <input  name="items['+countMain+'].dataSets['+i+'].members['+j+'].name" type="text" class="form-control">' +
                '                    </div>'
        }
    }
       /* '            <div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Item name</span>' +
        '                <input name="items['+countMain+'].name" type="text" class="form-control"/>' +
        '            </div>' +
        '            <div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Item value</span>' +
        '                <input  name="items['+countMain+'].dataSets[0].itemValue" type="text" class="form-control"/>' +
        '            </div>' +
        '            <div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Item remark</span>' +
        '                <input name="items['+countMain+'].dataSets[0].itemRemark" type="text" class="form-control"/>' +
        '            </div>' +
        '            <div class="input-group" style="margin-bottom: 10px;">' +
        '                <span class="input-group-addon">Member</span>' +
        '                <input  name="items['+countMain+'].dataSets[0].members[0]" type="text" class="form-control">' +
        '            </div>';*/
       p.innerHTML=html;

    myForm.appendChild(p);
    countMain++;
    return false;
}
var d = document,
    myForm = d.getElementById('input_form'),
    butAdd = d.getElementById('addfields'),
    countMain=0;
butAdd.addEventListener('click', addfields, false);
