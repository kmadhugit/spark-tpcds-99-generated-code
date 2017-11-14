/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow agg_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 025 */   private int agg_value12;
/* 026 */   private UnsafeRow agg_result1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 030 */   private UnsafeRow filter_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 033 */   private UnsafeRow project_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 038 */
/* 039 */   public GeneratedIterator(Object[] references) {
/* 040 */     this.references = references;
/* 041 */   }
/* 042 */
/* 043 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 044 */     partitionIndex = index;
/* 045 */     this.inputs = inputs;
/* 046 */     wholestagecodegen_init_0();
/* 047 */     wholestagecodegen_init_1();
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private void wholestagecodegen_init_0() {
/* 052 */     agg_initAgg = false;
/* 053 */
/* 054 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 055 */
/* 056 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 057 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 058 */     inputadapter_input = inputs[0];
/* 059 */     agg_result = new UnsafeRow(3);
/* 060 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 061 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 062 */
/* 063 */     agg_result1 = new UnsafeRow(7);
/* 064 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 065 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 066 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 067 */     filter_result = new UnsafeRow(7);
/* 068 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 069 */
/* 070 */   }
/* 071 */
/* 072 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 073 */     agg_hashMap = agg_plan.createHashMap();
/* 074 */
/* 075 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 076 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 077 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 078 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 079 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 080 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 081 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 082 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 083 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 084 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 085 */       long inputadapter_value4 = inputadapter_row.getLong(4);
/* 086 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 087 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 088 */
/* 089 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 090 */
/* 091 */       UnsafeRow agg_fastAggBuffer = null;
/* 092 */
/* 093 */       if (agg_fastAggBuffer == null) {
/* 094 */         // generate grouping key
/* 095 */         agg_rowWriter.zeroOutNullBytes();
/* 096 */
/* 097 */         if (inputadapter_isNull) {
/* 098 */           agg_rowWriter.setNullAt(0);
/* 099 */         } else {
/* 100 */           agg_rowWriter.write(0, inputadapter_value);
/* 101 */         }
/* 102 */
/* 103 */         if (inputadapter_isNull1) {
/* 104 */           agg_rowWriter.setNullAt(1);
/* 105 */         } else {
/* 106 */           agg_rowWriter.write(1, inputadapter_value1);
/* 107 */         }
/* 108 */
/* 109 */         if (inputadapter_isNull2) {
/* 110 */           agg_rowWriter.setNullAt(2);
/* 111 */         } else {
/* 112 */           agg_rowWriter.write(2, inputadapter_value2);
/* 113 */         }
/* 114 */         agg_value12 = 42;
/* 115 */
/* 116 */         if (!inputadapter_isNull) {
/* 117 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 118 */         }
/* 119 */
/* 120 */         if (!inputadapter_isNull1) {
/* 121 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 122 */         }
/* 123 */
/* 124 */         if (!inputadapter_isNull2) {
/* 125 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 126 */         }
/* 127 */         if (true) {
/* 128 */           // try to get the buffer from hash map
/* 129 */           agg_unsafeRowAggBuffer =
/* 130 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 131 */         }
/* 132 */         if (agg_unsafeRowAggBuffer == null) {
/* 133 */           if (agg_sorter == null) {
/* 134 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 135 */           } else {
/* 136 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 137 */           }
/* 138 */
/* 139 */           // the hash map had be spilled, it should have enough memory now,
/* 140 */           // try  to allocate buffer again.
/* 141 */           agg_unsafeRowAggBuffer =
/* 142 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 143 */           if (agg_unsafeRowAggBuffer == null) {
/* 144 */             // failed to allocate the first page
/* 145 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 146 */           }
/* 147 */         }
/* 148 */       }
/* 149 */
/* 150 */       if (agg_fastAggBuffer != null) {
/* 151 */         // update fast row
/* 152 */
/* 153 */       } else {
/* 154 */         // update unsafe row
/* 155 */
/* 156 */         // common sub-expressions
/* 157 */
/* 158 */         // evaluate aggregate function
/* 159 */         boolean agg_isNull14 = true;
/* 160 */         double agg_value17 = -1.0;
/* 161 */
/* 162 */         boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 163 */         double agg_value19 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 164 */         boolean agg_isNull15 = agg_isNull16;
/* 165 */         double agg_value18 = agg_value19;
/* 166 */         if (agg_isNull15) {
/* 167 */           boolean agg_isNull17 = false;
/* 168 */           double agg_value20 = -1.0;
/* 169 */           if (!false) {
/* 170 */             agg_value20 = (double) 0;
/* 171 */           }
/* 172 */           if (!agg_isNull17) {
/* 173 */             agg_isNull15 = false;
/* 174 */             agg_value18 = agg_value20;
/* 175 */           }
/* 176 */         }
/* 177 */
/* 178 */         if (!inputadapter_isNull3) {
/* 179 */           agg_isNull14 = false; // resultCode could change nullability.
/* 180 */           agg_value17 = agg_value18 + inputadapter_value3;
/* 181 */
/* 182 */         }
/* 183 */         boolean agg_isNull13 = agg_isNull14;
/* 184 */         double agg_value16 = agg_value17;
/* 185 */         if (agg_isNull13) {
/* 186 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 187 */           double agg_value23 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 188 */           if (!agg_isNull20) {
/* 189 */             agg_isNull13 = false;
/* 190 */             agg_value16 = agg_value23;
/* 191 */           }
/* 192 */         }
/* 193 */         boolean agg_isNull21 = false;
/* 194 */
/* 195 */         long agg_value25 = agg_unsafeRowAggBuffer.getLong(1);
/* 196 */
/* 197 */         long agg_value24 = -1L;
/* 198 */         agg_value24 = agg_value25 + inputadapter_value4;
/* 199 */         boolean agg_isNull25 = true;
/* 200 */         double agg_value28 = -1.0;
/* 201 */
/* 202 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 203 */         double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 204 */         boolean agg_isNull26 = agg_isNull27;
/* 205 */         double agg_value29 = agg_value30;
/* 206 */         if (agg_isNull26) {
/* 207 */           boolean agg_isNull28 = false;
/* 208 */           double agg_value31 = -1.0;
/* 209 */           if (!false) {
/* 210 */             agg_value31 = (double) 0;
/* 211 */           }
/* 212 */           if (!agg_isNull28) {
/* 213 */             agg_isNull26 = false;
/* 214 */             agg_value29 = agg_value31;
/* 215 */           }
/* 216 */         }
/* 217 */
/* 218 */         if (!inputadapter_isNull5) {
/* 219 */           agg_isNull25 = false; // resultCode could change nullability.
/* 220 */           agg_value28 = agg_value29 + inputadapter_value5;
/* 221 */
/* 222 */         }
/* 223 */         boolean agg_isNull24 = agg_isNull25;
/* 224 */         double agg_value27 = agg_value28;
/* 225 */         if (agg_isNull24) {
/* 226 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 227 */           double agg_value34 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 228 */           if (!agg_isNull31) {
/* 229 */             agg_isNull24 = false;
/* 230 */             agg_value27 = agg_value34;
/* 231 */           }
/* 232 */         }
/* 233 */         // update unsafe row buffer
/* 234 */         if (!agg_isNull13) {
/* 235 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value16);
/* 236 */         } else {
/* 237 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 238 */         }
/* 239 */
/* 240 */         agg_unsafeRowAggBuffer.setLong(1, agg_value24);
/* 241 */
/* 242 */         if (!agg_isNull24) {
/* 243 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value27);
/* 244 */         } else {
/* 245 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 246 */         }
/* 247 */
/* 248 */       }
/* 249 */       if (shouldStop()) return;
/* 250 */     }
/* 251 */
/* 252 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 253 */   }
/* 254 */
/* 255 */   private void wholestagecodegen_init_1() {
/* 256 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 7);
/* 257 */     project_result = new UnsafeRow(6);
/* 258 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 259 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 260 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 261 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 262 */
/* 263 */   }
/* 264 */
/* 265 */   protected void processNext() throws java.io.IOException {
/* 266 */     if (!agg_initAgg) {
/* 267 */       agg_initAgg = true;
/* 268 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 269 */       agg_doAggregateWithKeys();
/* 270 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 271 */     }
/* 272 */
/* 273 */     // output the result
/* 274 */
/* 275 */     while (agg_mapIter.next()) {
/* 276 */       wholestagecodegen_numOutputRows.add(1);
/* 277 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 278 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 279 */
/* 280 */       boolean agg_isNull32 = agg_aggKey.isNullAt(0);
/* 281 */       int agg_value35 = agg_isNull32 ? -1 : (agg_aggKey.getInt(0));
/* 282 */       boolean agg_isNull33 = agg_aggKey.isNullAt(1);
/* 283 */       int agg_value36 = agg_isNull33 ? -1 : (agg_aggKey.getInt(1));
/* 284 */       boolean agg_isNull34 = agg_aggKey.isNullAt(2);
/* 285 */       int agg_value37 = agg_isNull34 ? -1 : (agg_aggKey.getInt(2));
/* 286 */       boolean agg_isNull35 = agg_aggBuffer.isNullAt(0);
/* 287 */       double agg_value38 = agg_isNull35 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 288 */       long agg_value39 = agg_aggBuffer.getLong(1);
/* 289 */       boolean agg_isNull37 = agg_aggBuffer.isNullAt(2);
/* 290 */       double agg_value40 = agg_isNull37 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 291 */
/* 292 */       if (!(!(agg_isNull37))) continue;
/* 293 */
/* 294 */       boolean filter_isNull2 = true;
/* 295 */       boolean filter_value2 = false;
/* 296 */
/* 297 */       if (!false) {
/* 298 */         filter_isNull2 = false; // resultCode could change nullability.
/* 299 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value40, 4394.688530360977D) > 0;
/* 300 */
/* 301 */       }
/* 302 */       if (filter_isNull2 || !filter_value2) continue;
/* 303 */
/* 304 */       filter_numOutputRows.add(1);
/* 305 */
/* 306 */       project_holder.reset();
/* 307 */
/* 308 */       project_rowWriter.zeroOutNullBytes();
/* 309 */
/* 310 */       if (agg_isNull35) {
/* 311 */         project_rowWriter.setNullAt(0);
/* 312 */       } else {
/* 313 */         project_rowWriter.write(0, agg_value38);
/* 314 */       }
/* 315 */
/* 316 */       project_rowWriter.write(1, agg_value39);
/* 317 */
/* 318 */       project_rowWriter.write(2, ((UTF8String) references[3]));
/* 319 */
/* 320 */       if (agg_isNull32) {
/* 321 */         project_rowWriter.setNullAt(3);
/* 322 */       } else {
/* 323 */         project_rowWriter.write(3, agg_value35);
/* 324 */       }
/* 325 */
/* 326 */       if (agg_isNull33) {
/* 327 */         project_rowWriter.setNullAt(4);
/* 328 */       } else {
/* 329 */         project_rowWriter.write(4, agg_value36);
/* 330 */       }
/* 331 */
/* 332 */       if (agg_isNull34) {
/* 333 */         project_rowWriter.setNullAt(5);
/* 334 */       } else {
/* 335 */         project_rowWriter.write(5, agg_value37);
/* 336 */       }
/* 337 */       project_result.setTotalSize(project_holder.totalSize());
/* 338 */       append(project_result);
/* 339 */
/* 340 */       if (shouldStop()) return;
/* 341 */     }
/* 342 */
/* 343 */     agg_mapIter.close();
/* 344 */     if (agg_sorter == null) {
/* 345 */       agg_hashMap.free();
/* 346 */     }
/* 347 */   }
/* 348 */ }
