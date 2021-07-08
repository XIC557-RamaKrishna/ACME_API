import axios from 'axios'

const USER_API_URL = 'http://localhost:8999'

class StoreService {

    updateStore(id, store) {

        return axios.put(`${USER_API_URL}/updateStore/${id}`, store);
    }

    retrieveStore(id) {

        return axios.get(`${USER_API_URL}/getStore/${id}`);
    }
     
}

export default new StoreService()