class MedicalCalculator {

    static xmlHttp = new XMLHttpRequest();

    static receiveQuestionnaires(parentNodeId) {
        this.xmlHttp.onload = function () {
            let response = MedicalCalculator.xmlHttp.responseText;
            if (response != null && response.trim() !== "") {
                let container = document.getElementById(parentNodeId);
                while (container.firstChild) {
                    container.removeChild(container.firstChild);
                }
                let parser = new DOMParser();
                let elementDOM = parser.parseFromString(response, "text/html");
                document.getElementById(parentNodeId).appendChild(elementDOM);
            }
        };
        this.xmlHttp.open("GET", "/questionnaires-loading", false);
        this.xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        this.xmlHttp.send("message-type=get-all-questionnaires");
    }

    static receiveQuestionnaire(parentNodeId, anchorId, questionnaireTitle) {
        this.xmlHttp.onload = function () {
            let response = MedicalCalculator.xmlHttp.responseText;
            if (response != null && response.trim() !== "") {
                let container = document.getElementById(parentNodeId);
                while (container.firstChild) {
                    container.removeChild(container.firstChild);
                }
                let parser = new DOMParser();
                let elementDOM = parser.parseFromString(response, "text/html");
                document.getElementById(parentNodeId).appendChild(elementDOM);
                window.location = "#" + anchorId
            }
        };
        this.xmlHttp.open("GET", "/questionnaire-loading", true);
        this.xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        this.xmlHttp.send("message-type=get-questionnaire-data&questionnaire-title=" + questionnaireTitle);
    }
}