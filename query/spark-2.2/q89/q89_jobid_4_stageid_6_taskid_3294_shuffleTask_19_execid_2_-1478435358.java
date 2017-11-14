/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 010 */   private UnsafeRow filter_result;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 013 */   private UnsafeRow project_result;
/* 014 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 016 */
/* 017 */   public GeneratedIterator(Object[] references) {
/* 018 */     this.references = references;
/* 019 */   }
/* 020 */
/* 021 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 022 */     partitionIndex = index;
/* 023 */     this.inputs = inputs;
/* 024 */     inputadapter_input = inputs[0];
/* 025 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 026 */     filter_result = new UnsafeRow(9);
/* 027 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 160);
/* 028 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 9);
/* 029 */     project_result = new UnsafeRow(8);
/* 030 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 160);
/* 031 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 032 */
/* 033 */   }
/* 034 */
/* 035 */   protected void processNext() throws java.io.IOException {
/* 036 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 037 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 038 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 039 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 040 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 041 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 042 */
/* 043 */       boolean filter_isNull = true;
/* 044 */       boolean filter_value = false;
/* 045 */
/* 046 */       boolean filter_isNull1 = true;
/* 047 */       double filter_value1 = -1.0;
/* 048 */
/* 049 */       boolean filter_isNull3 = true;
/* 050 */       boolean filter_value3 = false;
/* 051 */
/* 052 */       if (!inputadapter_isNull8) {
/* 053 */         filter_isNull3 = false; // resultCode could change nullability.
/* 054 */         filter_value3 = (java.lang.Double.isNaN(inputadapter_value8) && java.lang.Double.isNaN(0.0D)) || inputadapter_value8 == 0.0D;
/* 055 */
/* 056 */       }
/* 057 */       boolean filter_isNull2 = filter_isNull3;
/* 058 */       boolean filter_value2 = false;
/* 059 */
/* 060 */       if (!filter_isNull3) {
/* 061 */         filter_value2 = !(filter_value3);
/* 062 */       }
/* 063 */       if (!filter_isNull2 && filter_value2) {
/* 064 */         boolean filter_isNull6 = false;
/* 065 */         double filter_value6 = -1.0;
/* 066 */         if (inputadapter_isNull8 || inputadapter_value8 == 0) {
/* 067 */           filter_isNull6 = true;
/* 068 */         } else {
/* 069 */           boolean filter_isNull8 = true;
/* 070 */           double filter_value8 = -1.0;
/* 071 */
/* 072 */           if (!inputadapter_isNull6) {
/* 073 */             if (!inputadapter_isNull8) {
/* 074 */               filter_isNull8 = false; // resultCode could change nullability.
/* 075 */               filter_value8 = inputadapter_value6 - inputadapter_value8;
/* 076 */
/* 077 */             }
/* 078 */
/* 079 */           }
/* 080 */           boolean filter_isNull7 = filter_isNull8;
/* 081 */           double filter_value7 = -1.0;
/* 082 */
/* 083 */           if (!filter_isNull8) {
/* 084 */             filter_value7 = (double)(java.lang.Math.abs(filter_value8));
/* 085 */           }
/* 086 */           if (filter_isNull7) {
/* 087 */             filter_isNull6 = true;
/* 088 */           } else {
/* 089 */             filter_value6 = (double)(filter_value7 / inputadapter_value8);
/* 090 */           }
/* 091 */         }
/* 092 */         filter_isNull1 = filter_isNull6;
/* 093 */         filter_value1 = filter_value6;
/* 094 */       }
/* 095 */
/* 096 */       else {
/* 097 */         final double filter_value12 = -1.0;
/* 098 */         filter_isNull1 = true;
/* 099 */         filter_value1 = filter_value12;
/* 100 */       }
/* 101 */       if (!filter_isNull1) {
/* 102 */         filter_isNull = false; // resultCode could change nullability.
/* 103 */         filter_value = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value1, 0.1D) > 0;
/* 104 */
/* 105 */       }
/* 106 */       if (filter_isNull || !filter_value) continue;
/* 107 */
/* 108 */       filter_numOutputRows.add(1);
/* 109 */
/* 110 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 111 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 112 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 113 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 114 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 115 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 116 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 117 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 118 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 119 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 120 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 121 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 122 */       project_holder.reset();
/* 123 */
/* 124 */       project_rowWriter.zeroOutNullBytes();
/* 125 */
/* 126 */       if (inputadapter_isNull) {
/* 127 */         project_rowWriter.setNullAt(0);
/* 128 */       } else {
/* 129 */         project_rowWriter.write(0, inputadapter_value);
/* 130 */       }
/* 131 */
/* 132 */       if (inputadapter_isNull1) {
/* 133 */         project_rowWriter.setNullAt(1);
/* 134 */       } else {
/* 135 */         project_rowWriter.write(1, inputadapter_value1);
/* 136 */       }
/* 137 */
/* 138 */       if (inputadapter_isNull2) {
/* 139 */         project_rowWriter.setNullAt(2);
/* 140 */       } else {
/* 141 */         project_rowWriter.write(2, inputadapter_value2);
/* 142 */       }
/* 143 */
/* 144 */       if (inputadapter_isNull3) {
/* 145 */         project_rowWriter.setNullAt(3);
/* 146 */       } else {
/* 147 */         project_rowWriter.write(3, inputadapter_value3);
/* 148 */       }
/* 149 */
/* 150 */       if (inputadapter_isNull4) {
/* 151 */         project_rowWriter.setNullAt(4);
/* 152 */       } else {
/* 153 */         project_rowWriter.write(4, inputadapter_value4);
/* 154 */       }
/* 155 */
/* 156 */       if (inputadapter_isNull5) {
/* 157 */         project_rowWriter.setNullAt(5);
/* 158 */       } else {
/* 159 */         project_rowWriter.write(5, inputadapter_value5);
/* 160 */       }
/* 161 */
/* 162 */       if (inputadapter_isNull6) {
/* 163 */         project_rowWriter.setNullAt(6);
/* 164 */       } else {
/* 165 */         project_rowWriter.write(6, inputadapter_value6);
/* 166 */       }
/* 167 */
/* 168 */       if (inputadapter_isNull8) {
/* 169 */         project_rowWriter.setNullAt(7);
/* 170 */       } else {
/* 171 */         project_rowWriter.write(7, inputadapter_value8);
/* 172 */       }
/* 173 */       project_result.setTotalSize(project_holder.totalSize());
/* 174 */       append(project_result);
/* 175 */       if (shouldStop()) return;
/* 176 */     }
/* 177 */   }
/* 178 */ }
