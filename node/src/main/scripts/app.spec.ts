const underTest = require('./app');
const request = require('supertest');
const toMatchImageSnapshot = require('jest-image-snapshot');

expect.extend({ toMatchImageSnapshot });

test('show the 13th amendment', async () => {
    const response = await request(underTest).get('/api/images/o_dRqrNJ62wzlgLilTrLxkHqGmvAS9qTpa4z4pjyFqA=_54-86_0-218.jpg');
    expect(response.statusCode).toBe(200);
    expect(response.body).toMatchImageSnapshot();
})

test('show some video captions', async () => {
    const response = await request(underTest).get('/api/images/vrhLapmIbWECYassLC2Umf7Z16fusYgWWGhTP7KgIYU=_5839.620-5949.290.jpg');
    expect(response.statusCode).toBe(200);
    expect(response.body).toMatchImageSnapshot();
})
