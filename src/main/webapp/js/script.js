function getAll() {
    fetch("ws/cekis", {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera duomenu";
        } else {
            appDiv.innerHTML = JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function getOne() {
    const cekisId = document.getElementById("cekisId").value;
    fetch("ws/cekis/" + cekisId, {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera tokio";
        } else {
            document.getElementById("cekisId").value = data.id;
            document.getElementById("data").value = data.data;
            document.getElementById("parduotuve").value = data.parduotuve;
            document.getElementById("aprasymas").value = data.aprasymas;
            appDiv.innerHTML = JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function update() {
    const cekisId = document.getElementById("cekisId").value;
    const cekisData = document.getElementById("data").value;
    const cekisParduotuve = document.getElementById("parduotuve").value;
    const cekisAprasymas = document.getElementById("aprasymas").value;
    const cekis = {
        id: cekisId,
        data: cekisData,
        parduotuve: cekisParduotuve
    };
    if (cekisAprasymas) {
        cekis.aprasymas = cekisAprasymas;
    }
    fetch("ws/cekis/" + cekisId, {
        method: "PUT",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cekis)
    })
    .then(response => {
        if (response.status < 200 || response.status >= 300) {
            throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
        }
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "updated";
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function insert() {
    const cekisData = document.getElementById("data").value;
    const cekisParduotuve = document.getElementById("parduotuve").value;
    const cekisAprasymas = document.getElementById("aprasymas").value;
    const cekis = {
        data: cekisData,
        parduotuve: cekisParduotuve
    };
    if (cekisAprasymas) {
        cekis.aprasymas = cekisAprasymas;
    }
    fetch("ws/cekis", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cekis)
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera tokio";
        } else {
            document.getElementById("cekisId").value = data.id;
            document.getElementById("data").value = data.data;
            document.getElementById("parduotuve").value = data.parduotuve;
            document.getElementById("aprasymas").value = data.aprasymas;
            appDiv.innerHTML = "inserted: " + JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function deleteOne() {
    const cekisId = document.getElementById("cekisId").value;
    fetch("ws/cekis/" + cekisId, {
        method: "DELETE"
    })
    .then(response => {
        if (response.status < 200 || response.status >= 300) {
            throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
        }
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "deleted";
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

//--------------------------------------------------------------

function getAllPrekes() {
    const cekisId = document.getElementById("cekisId").value;
    console.log("ws/cekis/"+ cekisId +"/preke");
    fetch("ws/cekis/"+ cekisId +"/preke", {

        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera duomenu";
        } else {
            appDiv.innerHTML = JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function getOnePreke() {
    const cekisId = document.getElementById("cekisId").value;
    const prekeId = document.getElementById("prekeId").value;
    console.log("ws/cekis/"+ cekisId +"/preke/" + prekeId);
    fetch("ws/cekis/"+ cekisId +"/preke/" + prekeId, {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera tokio";
        } else {
            document.getElementById("prekeId").value = data.id;

            document.getElementById("cekisId").value = data.cekis.id;
            document.getElementById("data").value = data.cekis.data;
            document.getElementById("parduotuve").value = data.cekis.parduotuve;
            document.getElementById("aprasymas").value = data.cekis.aprasymas;

            document.getElementById("preke").value = data.preke;
            document.getElementById("kaina").value = data.kaina;
            document.getElementById("kiekis").value = data.kiekis;

            document.getElementById("tipasId").value = data.tipas.id;
            document.getElementById("pavadinimas").value = data.tipas.pavadinimas;
            appDiv.innerHTML = JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function updatePreke() {
    const cekisId = document.getElementById("cekisId").value;
    const cekisData = document.getElementById("data").value;
    const cekisParduotuve = document.getElementById("parduotuve").value;
    const cekisAprasymas = document.getElementById("aprasymas").value;

    const prekeId = document.getElementById("prekeId").value;
//    const prekeCekis = document.getElementById("cekis").value;
    const prekePreke = document.getElementById("preke").value;
    const prekeKiekis = document.getElementById("kiekis").value;
    const prekeKaina = document.getElementById("kaina").value;

    const tipasId = document.getElementById("tipasId").value;
    const tipasPav = document.getElementById("pavadinimas").value;
//    const prekeTipas = document.getElementById("tipas").value;
    const preke = {
        id: prekeId,
        cekis_id: cekisId,
//        cekis: prekeCekis,
        preke: prekePreke,
        kiekis: prekeKiekis,
        kaina: prekeKaina,
//        tipas: prekeTipas
        tipas_id: tipasId
    };
    fetch("ws/cekis/"+ cekisId +"/preke/" + prekeId, {
        method: "PUT",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(preke)
    })
    .then(response => {
        if (response.status < 200 || response.status >= 300) {
            throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
        }
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "updated";
        appDiv.innerHTML = JSON.stringify(data);
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function insertPreke() {
     const cekisId = document.getElementById("cekisId").value;
        const cekisData = document.getElementById("data").value;
        const cekisParduotuve = document.getElementById("parduotuve").value;
        const cekisAprasymas = document.getElementById("aprasymas").value;

        const prekeId = document.getElementById("prekeId").value;
        const prekePreke = document.getElementById("preke").value;
        const prekeKiekis = document.getElementById("kiekis").value;
        const prekeKaina = document.getElementById("kaina").value;

        const tipasId = document.getElementById("tipasId").value;
        const tipasPav = document.getElementById("pavadinimas").value;

        const preke = {
            id: prekeId,

            preke: prekePreke,
            kiekis: prekeKiekis,
            kaina: prekeKaina,
            tipas: {
            id: tipasId
            }
    };
    fetch("ws/cekis/"+ cekisId +"/preke", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(preke)
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera tokio";
        } else {
            document.getElementById("cekisId").value = data.cekis.id;
            document.getElementById("preke").value = data.preke;
            document.getElementById("kiekis").value = data.kiekis;
            document.getElementById("kaina").value = data.kaina;
            document.getElementById("tipasId").value = data.tipas.id;
            appDiv.innerHTML = "inserted: " + JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function deleteOnePreke() {
    const cekisId = document.getElementById("cekisId").value;
    const prekeId = document.getElementById("prekeId").value;
    fetch("ws/cekis/"+ cekisId +"/preke/" + prekeId, {
        method: "DELETE"
    })
    .then(response => {
        if (response.status < 200 || response.status >= 300) {
            throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
        }
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "deleted";
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}
