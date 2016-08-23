using System.Web.Mvc;
using B2CTouresBalon.Controllers;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace B2CTouresBalon.Tests.Controllers
{
    [TestClass]
    public class HomeControllerTest
    {
        [TestMethod]
        public void Index()
        {
            // Arrange
            var controller = new HomeController();

            // Act
            var result = controller.Index() as ViewResult;

            // Assert
            Assert.IsNotNull(result);
        }
    }
}
