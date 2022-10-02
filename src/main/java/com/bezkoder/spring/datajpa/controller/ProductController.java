package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.dto.*;
import com.bezkoder.spring.datajpa.entity.*;
import com.bezkoder.spring.datajpa.repository.ProductTypeRepo;
import com.bezkoder.spring.datajpa.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final BrandService brandService;
    private final ColorService colorService;
    private final ImageService imageService;
    private final FeatureService featureService;
    private final SpecificationTypeService specificationTypeService;
    private final ProductTypeRepo productTypeRepo;

    @GetMapping
    public ResponseEntity<ResponseDTO> getProductByCondition(@RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice,
                                                  @RequestParam(required = false) List<Long> checkedBrands){
//        if(checkedBrands.size() == 0) checkedBrands = null;
        ResponseDTO response = new ResponseDTO();
        response.setStatusCode(200);
        response.setContent(productService.findByCondition(minPrice, maxPrice, checkedBrands));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> getProductDetail(@PathVariable Long id){
        ResponseProductDTO response = new ResponseProductDTO();
        List<SpecificationTypeDTO> specificationTypeDTOList = new ArrayList<>();
        Product productEntity = productService.retrieve(id);
        List<Specification> specificationList = productEntity.getSpecifications();


        Set<SpecificationType> tempList = specificationList.stream().map(o -> o.getSpecificationType()).collect(Collectors.toSet());
        for (SpecificationType temp : tempList) {
            SpecificationTypeDTO specificationTypeDTO = new SpecificationTypeDTO();
            specificationTypeDTO.setName(temp.getName());
            specificationTypeDTO.setSpecificationList(specificationList.stream().filter(o -> o.getSpecificationType().getId() == temp.getId()).collect(Collectors.toList()));
            specificationTypeDTOList.add(specificationTypeDTO);
        }
        response.setId(productEntity.getId());
        response.setImgPath(productEntity.getImgPath());
        response.setBrand(productEntity.getBrand());
        response.setImages(productEntity.getImages());
        response.setFeatures(productEntity.getFeatures());
        response.setName(productEntity.getName());
        response.setProductTypes(productEntity.getProductTypes());
        response.setSpecificationTypeDTOs(specificationTypeDTOList);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/addColorForProduct")
    public void addColorForProduct(@RequestParam Long productId,
                                                      @RequestParam List<Long> colorIds){
//        Product product = productService.retrieve(productId);
//        for (Long colorId : colorIds) {
//            Color color = colorService.retrieve(colorId);
//            product.getColors().add(color);
//        }
//        productService.update(product);
    }

    @GetMapping("/findProductList")
    public ResponseEntity<List<Product>> getProductsInCart(@RequestParam(required = false) List<Long> productIdsInCart){
        return ResponseEntity.ok().body(productService.findProductsInCart(productIdsInCart));
    }

    @PutMapping()
    public ResponseEntity<ResponseDTO> updateProduct(@RequestBody ProductEditDTO dto){
        System.out.println("Tuan ANh DATN");
        Product product = productService.retrieve(dto.getProductId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setBrand(brandService.retrieve(dto.getBrandId()));
        product = productService.update(product);

        List<Feature> features = new ArrayList<>();
        for (String s : dto.getFeatures()) {
            Feature feature = new Feature();
            feature.setContent(s);
            feature.setProduct(product);
            features.add(feature);
        }
        featureService.deleteByProductId(product.getId());
        featureService.saveAll(features);

        List<Image> images = new ArrayList<>();
        for(ImageDTO i : dto.getImgList()){
            Image image = new Image();
            image.setName(i.getName());
            image.setImgPath(i.getImgPath());
            image.setColor(colorService.retrieve(i.getColorId()));
            image.setProduct(product);
            images.add(image);
        }
        imageService.deleteByProductId(product.getId());
        imageService.saveAll(images);


        productTypeRepo.deleteProductTypeByProductId(product.getId());
        for (ProductType pt:dto.getProductTypes()) {
            pt.setProduct(product);
        }
        productTypeRepo.saveAll(dto.getProductTypes());

        ResponseDTO response = new ResponseDTO();
        response.setStatusCode(200);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO> createProduct(@RequestBody ProductEditDTO dto){
        System.out.println("Tuan ANh DATN");
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setBrand(brandService.retrieve(dto.getBrandId()));
        product = productService.update(product);

        List<Feature> features = new ArrayList<>();
        for (String s : dto.getFeatures()) {
            Feature feature = new Feature();
            feature.setContent(s);
            feature.setProduct(product);
            features.add(feature);
        }
        featureService.saveAll(features);

        List<Image> images = new ArrayList<>();
        for(ImageDTO i : dto.getImgList()){
            Image image = new Image();
            image.setName(i.getName());
            image.setImgPath(i.getImgPath());
            image.setColor(colorService.retrieve(i.getColorId()));
            image.setProduct(product);
            images.add(image);
        }
        imageService.saveAll(images);

        productTypeRepo.saveAll(dto.getProductTypes());
        ResponseDTO response = new ResponseDTO();
        response.setStatusCode(200);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        ResponseDTO response = new ResponseDTO();
        response.setStatusCode(200);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/save-imgs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveUploadedImgs(@ModelAttribute UploadedImgDTO dto) throws IOException {
        // save image
        File f = null;
        if (dto.getFileList() != null) {
//            String fName = tempName.replace("{name}", dto.getFile().getName()).replace("{time}",
//                    String.valueOf(System.currentTimeMillis()));
            for (MultipartFile file : dto.getFileList()) {


            StringBuilder path = new StringBuilder();
            path.append("C:\\Users\\TUAN ANH\\Desktop\\Reckless\\full-version\\src\\assets\\images\\pages\\eCommerce").append("\\");

//            StringBuilder savePath = new StringBuilder(
//                    new File(System.getProperty("user.dir")).getParent().replace("\\", "/"));
//            savePath.append(path.toString());

            path.append(file.getOriginalFilename());

            try (OutputStream outputStream = new FileOutputStream(path.toString())) {
                outputStream.write(file.getBytes());
                outputStream.close();
                new File(path.toString());
            }
            }
        }
    }
}

