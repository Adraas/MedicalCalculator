class MedicalCalculators {

    static xmlHttp = new XMLHttpRequest();

    static receiveQuestionnaires() {
        this.xmlHttp.onload = function () {
            let parentNodeId = "questionnaires";
            MedicalCalculators.updateChildElements(parentNodeId, null);
        };
        this.xmlHttp.open("GET", "/questionnaires-loading", false);
        this.xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        this.xmlHttp.send("message-type=get-all-questionnaires");
    }

    static receiveQuestionnaire(questionnaireTitle) {
        this.xmlHttp.onload = function () {
            let parentNodeId = "calculator";
            let anchorId = "current_calculator";
            MedicalCalculators.updateChildElements(parentNodeId);
            window.location = "#" + anchorId
        };
        this.xmlHttp.open("GET", "/questionnaire-loading", true);
        this.xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        this.xmlHttp.send("message-type=get-questionnaire-data&questionnaire-title=" + questionnaireTitle);
    }

    static updateChildElements(parentNodeId, extraElement) {
        let response = MedicalCalculators.xmlHttp.responseText;
        if (response != null && response.trim() !== "") {
            let container = document.getElementById(parentNodeId);
            while (container.firstChild) {
                container.removeChild(container.firstChild);
            }
            let parser = new DOMParser();
            let elementDOM = parser.parseFromString(response, "text/html");
            document.getElementById(parentNodeId).appendChild(elementDOM);
            if (extraElement != null) {
                elementDOM = parser.parseFromString(extraElement, "text/html");
                document.getElementById(parentNodeId).appendChild(elementDOM);
            }
        }
    }
}