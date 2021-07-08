document.querySelector('#readme').setAttribute('style', 'position: absolute; top: 0; left: 0; right: 0; bottom: 0; z-index: 100; background-color: white')
document.querySelector('body').appendChild(document.querySelector('#readme'))
window.print()
