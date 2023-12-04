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