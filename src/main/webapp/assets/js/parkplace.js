function format(str, arr) {
    if (!str)
        return str;

    var a = (typeof arguments[1] === 'object') ? arr : Array.prototype.slice.call(arguments).slice(1);

    return str.replace(/\{{([0-9]+)\}}/g, function (_, index) {
        return a[index];
    });
}

String.prototype.format = function (arr) {
    var a = (typeof arguments[1] === 'object') ? arr : Array.prototype.slice.call(arguments).slice(1);

    return format(this, a);
};