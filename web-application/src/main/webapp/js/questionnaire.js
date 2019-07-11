class Questionnaire {

    static xmlHttp = new XMLHttpRequest();

}

function cache(key, value) {
    if (typeof value == 'undefined') {
        return cache[key];
    }
    cache[key] = value;
}