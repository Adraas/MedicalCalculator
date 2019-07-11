class MedicalCalculator {

    static xmlHttp = new XMLHttpRequest();

    static receiveQuestionnaires() {
        this.xmlHttp.onload = function () {
            let parentNodeId = "questionnaires";
            MedicalCalculator.updateChildElements(parentNodeId);
        };
        this.xmlHttp.open("GET", "/questionnaires-loading", false);
        this.xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        this.xmlHttp.send("message-type=get-all-questionnaires");
    }

    static receiveQuestionnaire(questionnaireTitle) {
        this.xmlHttp.onload = function () {
            let parentNodeId = "calculator";
            let anchorId = "current_calculator";
            MedicalCalculator.updateChildElements(parentNodeId);
            window.location = "#" + anchorId
        };
        this.xmlHttp.open("GET", "/questionnaire-loading", true);
        this.xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        this.xmlHttp.send("message-type=get-questionnaire-data&questionnaire-title=" + questionnaireTitle);
    }

    static updateChildElements(parentNodeId) {
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
    }
}