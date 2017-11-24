package com.example.ebean.protocol;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author yuzk
 * @date 2017/11/24
 */
public interface ContactProtocol extends BaseProtocol{

    interface Insert {

        class CustomerVo {

            @NotEmpty
            private String type;
            private String typeDetail;
            @NotEmpty
            private String customerId;

            public String getType() {
                return type;
            }

            public CustomerVo setType(String type) {
                this.type = type;
                return this;
            }

            public String getTypeDetail() {
                return typeDetail;
            }

            public CustomerVo setTypeDetail(String typeDetail) {
                this.typeDetail = typeDetail;
                return this;
            }

            public String getCustomerId() {
                return customerId;
            }

            public CustomerVo setCustomerId(String customerId) {
                this.customerId = customerId;
                return this;
            }
        }
    }
}
