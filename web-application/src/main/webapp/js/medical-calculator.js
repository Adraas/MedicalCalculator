class MedicalCalculator {

    static xmlHttp = new XMLHttpRequest();

    static receiveList(parentNodeId) {
        this.xmlHttp.onload = function () {
            let response = MedicalCalculator.xmlHttp.responseText;
            if (response != null && response.trim() !== "") {
                let parser = new DOMParser();
                let elementDOM = parser.parseFromString(response, "text/html");
                document.getElementById(parentNodeId).appendChild(elementDOM);
            }
        };
        this.xmlHttp.open("GET", "/loading", false);
        this.xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        this.xmlHttp.send("get-all-questionnaires");
    }
}