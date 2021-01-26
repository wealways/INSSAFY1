import http from './http';

export function login(email, password) {
  return http.post('/account/login', {
    email: email,
    password: password,
  });
}

//member 객체로 매개변수 받음
export function join(member) {
  return http.post('/account/signup', member);
}

export function duplicate(email) {
  return http.get('/account/duplicate/' + email);
}

export function modify(email, password) {
  return http.post('/account/modify', {
    email: email,
    password: password,
  });
}
