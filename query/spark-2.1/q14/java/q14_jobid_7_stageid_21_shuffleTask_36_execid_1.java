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
/* 075 */     while (inputadapter_input.hasNext()) {
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
/* 157 */         boolean agg_isNull13 = false;
/* 158 */         double agg_value16 = -1.0;
/* 159 */         if (!false) {
/* 160 */           agg_value16 = (double) 0;
/* 161 */         }
/* 162 */         // evaluate aggregate function
/* 163 */         boolean agg_isNull16 = true;
/* 164 */         double agg_value19 = -1.0;
/* 165 */
/* 166 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 167 */         double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 168 */         boolean agg_isNull17 = agg_isNull18;
/* 169 */         double agg_value20 = agg_value21;
/* 170 */         if (agg_isNull17) {
/* 171 */           if (!agg_isNull13) {
/* 172 */             agg_isNull17 = false;
/* 173 */             agg_value20 = agg_value16;
/* 174 */           }
/* 175 */         }
/* 176 */
/* 177 */         if (!inputadapter_isNull3) {
/* 178 */           agg_isNull16 = false; // resultCode could change nullability.
/* 179 */           agg_value19 = agg_value20 + inputadapter_value3;
/* 180 */
/* 181 */         }
/* 182 */         boolean agg_isNull15 = agg_isNull16;
/* 183 */         double agg_value18 = agg_value19;
/* 184 */         if (agg_isNull15) {
/* 185 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 186 */           double agg_value23 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 187 */           if (!agg_isNull20) {
/* 188 */             agg_isNull15 = false;
/* 189 */             agg_value18 = agg_value23;
/* 190 */           }
/* 191 */         }
/* 192 */         boolean agg_isNull21 = false;
/* 193 */
/* 194 */         long agg_value25 = agg_unsafeRowAggBuffer.getLong(1);
/* 195 */
/* 196 */         long agg_value24 = -1L;
/* 197 */         agg_value24 = agg_value25 + inputadapter_value4;
/* 198 */         boolean agg_isNull25 = true;
/* 199 */         double agg_value28 = -1.0;
/* 200 */
/* 201 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 202 */         double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 203 */         boolean agg_isNull26 = agg_isNull27;
/* 204 */         double agg_value29 = agg_value30;
/* 205 */         if (agg_isNull26) {
/* 206 */           if (!agg_isNull13) {
/* 207 */             agg_isNull26 = false;
/* 208 */             agg_value29 = agg_value16;
/* 209 */           }
/* 210 */         }
/* 211 */
/* 212 */         if (!inputadapter_isNull5) {
/* 213 */           agg_isNull25 = false; // resultCode could change nullability.
/* 214 */           agg_value28 = agg_value29 + inputadapter_value5;
/* 215 */
/* 216 */         }
/* 217 */         boolean agg_isNull24 = agg_isNull25;
/* 218 */         double agg_value27 = agg_value28;
/* 219 */         if (agg_isNull24) {
/* 220 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 221 */           double agg_value32 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 222 */           if (!agg_isNull29) {
/* 223 */             agg_isNull24 = false;
/* 224 */             agg_value27 = agg_value32;
/* 225 */           }
/* 226 */         }
/* 227 */         // update unsafe row buffer
/* 228 */         if (!agg_isNull15) {
/* 229 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 230 */         } else {
/* 231 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 232 */         }
/* 233 */
/* 234 */         agg_unsafeRowAggBuffer.setLong(1, agg_value24);
/* 235 */
/* 236 */         if (!agg_isNull24) {
/* 237 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value27);
/* 238 */         } else {
/* 239 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 240 */         }
/* 241 */
/* 242 */       }
/* 243 */       if (shouldStop()) return;
/* 244 */     }
/* 245 */
/* 246 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 247 */   }
/* 248 */
/* 249 */   private void wholestagecodegen_init_1() {
/* 250 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 7);
/* 251 */     project_result = new UnsafeRow(6);
/* 252 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 253 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 254 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 255 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 256 */
/* 257 */   }
/* 258 */
/* 259 */   protected void processNext() throws java.io.IOException {
/* 260 */     if (!agg_initAgg) {
/* 261 */       agg_initAgg = true;
/* 262 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 263 */       agg_doAggregateWithKeys();
/* 264 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 265 */     }
/* 266 */
/* 267 */     // output the result
/* 268 */
/* 269 */     while (agg_mapIter.next()) {
/* 270 */       wholestagecodegen_numOutputRows.add(1);
/* 271 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 272 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 273 */
/* 274 */       boolean agg_isNull30 = agg_aggKey.isNullAt(0);
/* 275 */       int agg_value33 = agg_isNull30 ? -1 : (agg_aggKey.getInt(0));
/* 276 */       boolean agg_isNull31 = agg_aggKey.isNullAt(1);
/* 277 */       int agg_value34 = agg_isNull31 ? -1 : (agg_aggKey.getInt(1));
/* 278 */       boolean agg_isNull32 = agg_aggKey.isNullAt(2);
/* 279 */       int agg_value35 = agg_isNull32 ? -1 : (agg_aggKey.getInt(2));
/* 280 */       boolean agg_isNull33 = agg_aggBuffer.isNullAt(0);
/* 281 */       double agg_value36 = agg_isNull33 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 282 */       long agg_value37 = agg_aggBuffer.getLong(1);
/* 283 */       boolean agg_isNull35 = agg_aggBuffer.isNullAt(2);
/* 284 */       double agg_value38 = agg_isNull35 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 285 */
/* 286 */       if (!(!(agg_isNull35))) continue;
/* 287 */
/* 288 */       boolean filter_isNull2 = true;
/* 289 */       boolean filter_value2 = false;
/* 290 */
/* 291 */       final double filter_value4 = -1.0;
/* 292 */       if (!true) {
/* 293 */         filter_isNull2 = false; // resultCode could change nullability.
/* 294 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value38, filter_value4) > 0;
/* 295 */
/* 296 */       }
/* 297 */       if (filter_isNull2 || !filter_value2) continue;
/* 298 */
/* 299 */       filter_numOutputRows.add(1);
/* 300 */
/* 301 */       Object agg_obj = ((Expression) references[3]).eval(null);
/* 302 */       UTF8String agg_value42 = (UTF8String) agg_obj;
/* 303 */       project_holder.reset();
/* 304 */
/* 305 */       project_rowWriter.zeroOutNullBytes();
/* 306 */
/* 307 */       if (agg_isNull33) {
/* 308 */         project_rowWriter.setNullAt(0);
/* 309 */       } else {
/* 310 */         project_rowWriter.write(0, agg_value36);
/* 311 */       }
/* 312 */
/* 313 */       project_rowWriter.write(1, agg_value37);
/* 314 */
/* 315 */       project_rowWriter.write(2, agg_value42);
/* 316 */
/* 317 */       if (agg_isNull30) {
/* 318 */         project_rowWriter.setNullAt(3);
/* 319 */       } else {
/* 320 */         project_rowWriter.write(3, agg_value33);
/* 321 */       }
/* 322 */
/* 323 */       if (agg_isNull31) {
/* 324 */         project_rowWriter.setNullAt(4);
/* 325 */       } else {
/* 326 */         project_rowWriter.write(4, agg_value34);
/* 327 */       }
/* 328 */
/* 329 */       if (agg_isNull32) {
/* 330 */         project_rowWriter.setNullAt(5);
/* 331 */       } else {
/* 332 */         project_rowWriter.write(5, agg_value35);
/* 333 */       }
/* 334 */       project_result.setTotalSize(project_holder.totalSize());
/* 335 */       append(project_result);
/* 336 */
/* 337 */       if (shouldStop()) return;
/* 338 */     }
/* 339 */
/* 340 */     agg_mapIter.close();
/* 341 */     if (agg_sorter == null) {
/* 342 */       agg_hashMap.free();
/* 343 */     }
/* 344 */   }
/* 345 */ }
