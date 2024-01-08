const baseUrl = 'http://localhost:8080/'

export const postAncestor = (payload) => {
    return fetch(baseUrl + "ancestors", {
        method: "POST",
        body: JSON.stringify(payload),
        headers: {"Content-Type" : "application/json"}
    }).then(res => res.json())

}

export const getAllAncestors = () => {
    return fetch(baseUrl + "ancestors", {
        method: "GET",
        headers: {"Content-Type" : "application/json"}
    }).then(res => res.json())

}

export const postEvent = (payload) => {
    let eventRoute = ""
    if (payload.type == "BIRTH"){
        eventRoute = "births"
    } else if (payload.type == "DEATH") {
        eventRoute = "deaths"
    }
    return fetch(baseUrl + eventRoute, {
        method: "POST",
        body: JSON.stringify(payload),
        headers:{"Content-Type" : "application/json"}
    }).then(res => res.json())
}

export const getAllBirths = () => {
    return fetch(baseUrl + "births", {
        method: "GET",
        headers:{"Content-Type" : "application/json"}
    }).then(res => res.json())
}

export const addBirth = (payload, ancestorId) => {
    return fetch(baseUrl + "ancestors/" + ancestorId + "/birth", {
        method: "PUT",
        body: JSON.stringify(payload),
        headers:{"Content-Type" : "application/json"}
    }).then(res => res.json())
}