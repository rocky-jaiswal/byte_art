const Triangles = require('./triangles');

test('gives some triangles back', () => {
  const triangles = Triangles.generate(5, 10);
  expect(triangles.length).toBeGreaterThan(1);
});
