/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private UnsafeRow scan_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 022 */   private UnsafeRow filter_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 025 */   private UnsafeRow project_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 028 */
/* 029 */   public GeneratedIterator(Object[] references) {
/* 030 */     this.references = references;
/* 031 */   }
/* 032 */
/* 033 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 034 */     partitionIndex = index;
/* 035 */     this.inputs = inputs;
/* 036 */     wholestagecodegen_init_0();
/* 037 */     wholestagecodegen_init_1();
/* 038 */
/* 039 */   }
/* 040 */
/* 041 */   private void wholestagecodegen_init_0() {
/* 042 */     scan_input = inputs[0];
/* 043 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 044 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 045 */     scan_scanTime1 = 0;
/* 046 */     scan_batch = null;
/* 047 */     scan_batchIdx = 0;
/* 048 */     scan_colInstance0 = null;
/* 049 */     scan_colInstance1 = null;
/* 050 */     scan_colInstance2 = null;
/* 051 */     scan_colInstance3 = null;
/* 052 */     scan_result = new UnsafeRow(4);
/* 053 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 96);
/* 054 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 055 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     filter_result = new UnsafeRow(4);
/* 057 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 058 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 059 */     project_result = new UnsafeRow(4);
/* 060 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 061 */
/* 062 */   }
/* 063 */
/* 064 */   private void scan_nextBatch() throws java.io.IOException {
/* 065 */     long getBatchStart = System.nanoTime();
/* 066 */     if (scan_input.hasNext()) {
/* 067 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 068 */       scan_numOutputRows.add(scan_batch.numRows());
/* 069 */       scan_batchIdx = 0;
/* 070 */       scan_colInstance0 = scan_batch.column(0);
/* 071 */       scan_colInstance1 = scan_batch.column(1);
/* 072 */       scan_colInstance2 = scan_batch.column(2);
/* 073 */       scan_colInstance3 = scan_batch.column(3);
/* 074 */
/* 075 */     }
/* 076 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 077 */   }
/* 078 */
/* 079 */   private void wholestagecodegen_init_1() {
/* 080 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   protected void processNext() throws java.io.IOException {
/* 085 */     if (scan_batch == null) {
/* 086 */       scan_nextBatch();
/* 087 */     }
/* 088 */     while (scan_batch != null) {
/* 089 */       int scan_numRows = scan_batch.numRows();
/* 090 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 091 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 092 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 093 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 094 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 095 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 096 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 097 */
/* 098 */         boolean filter_value2 = false;
/* 099 */         boolean filter_isNull2 = scan_isNull3;
/* 100 */         if (!filter_isNull2) {
/* 101 */           if (!filter_value2) {
/* 102 */             if (false) {
/* 103 */               filter_isNull2 = true;
/* 104 */             } else if (scan_value3.equals(((UTF8String) references[3]))) {
/* 105 */               filter_isNull2 = false;
/* 106 */               filter_value2 = true;
/* 107 */             }
/* 108 */           }
/* 109 */
/* 110 */           if (!filter_value2) {
/* 111 */             if (false) {
/* 112 */               filter_isNull2 = true;
/* 113 */             } else if (scan_value3.equals(((UTF8String) references[4]))) {
/* 114 */               filter_isNull2 = false;
/* 115 */               filter_value2 = true;
/* 116 */             }
/* 117 */           }
/* 118 */
/* 119 */           if (!filter_value2) {
/* 120 */             if (false) {
/* 121 */               filter_isNull2 = true;
/* 122 */             } else if (scan_value3.equals(((UTF8String) references[5]))) {
/* 123 */               filter_isNull2 = false;
/* 124 */               filter_value2 = true;
/* 125 */             }
/* 126 */           }
/* 127 */
/* 128 */         }
/* 129 */         boolean filter_isNull1 = false;
/* 130 */         boolean filter_value1 = false;
/* 131 */
/* 132 */         if (!filter_isNull2 && !filter_value2) {
/* 133 */         } else {
/* 134 */           boolean filter_value7 = false;
/* 135 */           boolean filter_isNull7 = scan_isNull2;
/* 136 */           if (!filter_isNull7) {
/* 137 */             if (!filter_value7) {
/* 138 */               if (false) {
/* 139 */                 filter_isNull7 = true;
/* 140 */               } else if (scan_value2.equals(((UTF8String) references[6]))) {
/* 141 */                 filter_isNull7 = false;
/* 142 */                 filter_value7 = true;
/* 143 */               }
/* 144 */             }
/* 145 */
/* 146 */             if (!filter_value7) {
/* 147 */               if (false) {
/* 148 */                 filter_isNull7 = true;
/* 149 */               } else if (scan_value2.equals(((UTF8String) references[7]))) {
/* 150 */                 filter_isNull7 = false;
/* 151 */                 filter_value7 = true;
/* 152 */               }
/* 153 */             }
/* 154 */
/* 155 */             if (!filter_value7) {
/* 156 */               if (false) {
/* 157 */                 filter_isNull7 = true;
/* 158 */               } else if (scan_value2.equals(((UTF8String) references[8]))) {
/* 159 */                 filter_isNull7 = false;
/* 160 */                 filter_value7 = true;
/* 161 */               }
/* 162 */             }
/* 163 */
/* 164 */           }
/* 165 */           if (!filter_isNull7 && !filter_value7) {
/* 166 */           } else if (!filter_isNull2 && !filter_isNull7) {
/* 167 */             filter_value1 = true;
/* 168 */           } else {
/* 169 */             filter_isNull1 = true;
/* 170 */           }
/* 171 */         }
/* 172 */         boolean filter_isNull = false;
/* 173 */         boolean filter_value = true;
/* 174 */
/* 175 */         if (!filter_isNull1 && filter_value1) {
/* 176 */         } else {
/* 177 */           boolean filter_value13 = false;
/* 178 */           boolean filter_isNull13 = scan_isNull3;
/* 179 */           if (!filter_isNull13) {
/* 180 */             if (!filter_value13) {
/* 181 */               if (false) {
/* 182 */                 filter_isNull13 = true;
/* 183 */               } else if (scan_value3.equals(((UTF8String) references[9]))) {
/* 184 */                 filter_isNull13 = false;
/* 185 */                 filter_value13 = true;
/* 186 */               }
/* 187 */             }
/* 188 */
/* 189 */             if (!filter_value13) {
/* 190 */               if (false) {
/* 191 */                 filter_isNull13 = true;
/* 192 */               } else if (scan_value3.equals(((UTF8String) references[10]))) {
/* 193 */                 filter_isNull13 = false;
/* 194 */                 filter_value13 = true;
/* 195 */               }
/* 196 */             }
/* 197 */
/* 198 */             if (!filter_value13) {
/* 199 */               if (false) {
/* 200 */                 filter_isNull13 = true;
/* 201 */               } else if (scan_value3.equals(((UTF8String) references[11]))) {
/* 202 */                 filter_isNull13 = false;
/* 203 */                 filter_value13 = true;
/* 204 */               }
/* 205 */             }
/* 206 */
/* 207 */           }
/* 208 */           boolean filter_isNull12 = false;
/* 209 */           boolean filter_value12 = false;
/* 210 */
/* 211 */           if (!filter_isNull13 && !filter_value13) {
/* 212 */           } else {
/* 213 */             boolean filter_value18 = false;
/* 214 */             boolean filter_isNull18 = scan_isNull2;
/* 215 */             if (!filter_isNull18) {
/* 216 */               if (!filter_value18) {
/* 217 */                 if (false) {
/* 218 */                   filter_isNull18 = true;
/* 219 */                 } else if (scan_value2.equals(((UTF8String) references[12]))) {
/* 220 */                   filter_isNull18 = false;
/* 221 */                   filter_value18 = true;
/* 222 */                 }
/* 223 */               }
/* 224 */
/* 225 */               if (!filter_value18) {
/* 226 */                 if (false) {
/* 227 */                   filter_isNull18 = true;
/* 228 */                 } else if (scan_value2.equals(((UTF8String) references[13]))) {
/* 229 */                   filter_isNull18 = false;
/* 230 */                   filter_value18 = true;
/* 231 */                 }
/* 232 */               }
/* 233 */
/* 234 */               if (!filter_value18) {
/* 235 */                 if (false) {
/* 236 */                   filter_isNull18 = true;
/* 237 */                 } else if (scan_value2.equals(((UTF8String) references[14]))) {
/* 238 */                   filter_isNull18 = false;
/* 239 */                   filter_value18 = true;
/* 240 */                 }
/* 241 */               }
/* 242 */
/* 243 */             }
/* 244 */             if (!filter_isNull18 && !filter_value18) {
/* 245 */             } else if (!filter_isNull13 && !filter_isNull18) {
/* 246 */               filter_value12 = true;
/* 247 */             } else {
/* 248 */               filter_isNull12 = true;
/* 249 */             }
/* 250 */           }
/* 251 */           if (!filter_isNull12 && filter_value12) {
/* 252 */           } else if (!filter_isNull1 && !filter_isNull12) {
/* 253 */             filter_value = false;
/* 254 */           } else {
/* 255 */             filter_isNull = true;
/* 256 */           }
/* 257 */         }
/* 258 */         if (filter_isNull || !filter_value) continue;
/* 259 */
/* 260 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 261 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 262 */
/* 263 */         if (!(!(scan_isNull))) continue;
/* 264 */
/* 265 */         filter_numOutputRows.add(1);
/* 266 */
/* 267 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 268 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 269 */         project_holder.reset();
/* 270 */
/* 271 */         project_rowWriter.zeroOutNullBytes();
/* 272 */
/* 273 */         project_rowWriter.write(0, scan_value);
/* 274 */
/* 275 */         if (scan_isNull1) {
/* 276 */           project_rowWriter.setNullAt(1);
/* 277 */         } else {
/* 278 */           project_rowWriter.write(1, scan_value1);
/* 279 */         }
/* 280 */
/* 281 */         if (scan_isNull2) {
/* 282 */           project_rowWriter.setNullAt(2);
/* 283 */         } else {
/* 284 */           project_rowWriter.write(2, scan_value2);
/* 285 */         }
/* 286 */
/* 287 */         if (scan_isNull3) {
/* 288 */           project_rowWriter.setNullAt(3);
/* 289 */         } else {
/* 290 */           project_rowWriter.write(3, scan_value3);
/* 291 */         }
/* 292 */         project_result.setTotalSize(project_holder.totalSize());
/* 293 */         append(project_result);
/* 294 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 295 */       }
/* 296 */       scan_batchIdx = scan_numRows;
/* 297 */       scan_batch = null;
/* 298 */       scan_nextBatch();
/* 299 */     }
/* 300 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 301 */     scan_scanTime1 = 0;
/* 302 */   }
/* 303 */ }
