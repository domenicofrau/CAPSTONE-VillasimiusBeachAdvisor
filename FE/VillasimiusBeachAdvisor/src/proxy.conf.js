const { createProxyMiddleware } = require('http-proxy-middleware');

const proxyConfig = {
  target: 'https://villasimiusbeachadvisor.com/',
  secure: false,
  bypass: function (req, res, proxyOptions) {
    const acceptHeader = req.headers.get('accept');
    if (acceptHeader && acceptHeader.includes('html')) {
      console.log('Skipping proxy for browser request.');
      return '/index.html';
    }
    req.headers.set('X-Custom-Header', 'yes');
    return undefined;
  },
};

module.exports = {
  '/api/proxy': createProxyMiddleware(proxyConfig),
};
