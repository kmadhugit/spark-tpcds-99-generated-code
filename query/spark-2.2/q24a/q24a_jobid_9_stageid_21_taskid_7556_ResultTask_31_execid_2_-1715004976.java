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
/* 012 */   private double agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value10;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 028 */   private UnsafeRow filter_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 036 */
/* 037 */   public GeneratedIterator(Object[] references) {
/* 038 */     this.references = references;
/* 039 */   }
/* 040 */
/* 041 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 042 */     partitionIndex = index;
/* 043 */     this.inputs = inputs;
/* 044 */     wholestagecodegen_init_0();
/* 045 */     wholestagecodegen_init_1();
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */   private void wholestagecodegen_init_0() {
/* 050 */     agg_initAgg = false;
/* 051 */
/* 052 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 053 */
/* 054 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 055 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     inputadapter_input = inputs[0];
/* 057 */     agg_result = new UnsafeRow(3);
/* 058 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 059 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 060 */
/* 061 */     agg_result1 = new UnsafeRow(5);
/* 062 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 063 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 064 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 065 */     filter_result = new UnsafeRow(5);
/* 066 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 067 */
/* 068 */   }
/* 069 */
/* 070 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 071 */     agg_hashMap = agg_plan.createHashMap();
/* 072 */
/* 073 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 074 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 075 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 076 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 077 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 078 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 079 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 080 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 081 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 082 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 083 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 084 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 085 */
/* 086 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 087 */
/* 088 */       UnsafeRow agg_fastAggBuffer = null;
/* 089 */
/* 090 */       if (agg_fastAggBuffer == null) {
/* 091 */         // generate grouping key
/* 092 */         agg_holder.reset();
/* 093 */
/* 094 */         agg_rowWriter.zeroOutNullBytes();
/* 095 */
/* 096 */         if (inputadapter_isNull) {
/* 097 */           agg_rowWriter.setNullAt(0);
/* 098 */         } else {
/* 099 */           agg_rowWriter.write(0, inputadapter_value);
/* 100 */         }
/* 101 */
/* 102 */         if (inputadapter_isNull1) {
/* 103 */           agg_rowWriter.setNullAt(1);
/* 104 */         } else {
/* 105 */           agg_rowWriter.write(1, inputadapter_value1);
/* 106 */         }
/* 107 */
/* 108 */         if (inputadapter_isNull2) {
/* 109 */           agg_rowWriter.setNullAt(2);
/* 110 */         } else {
/* 111 */           agg_rowWriter.write(2, inputadapter_value2);
/* 112 */         }
/* 113 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 114 */         agg_value10 = 42;
/* 115 */
/* 116 */         if (!inputadapter_isNull) {
/* 117 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value10);
/* 118 */         }
/* 119 */
/* 120 */         if (!inputadapter_isNull1) {
/* 121 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value10);
/* 122 */         }
/* 123 */
/* 124 */         if (!inputadapter_isNull2) {
/* 125 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value10);
/* 126 */         }
/* 127 */         if (true) {
/* 128 */           // try to get the buffer from hash map
/* 129 */           agg_unsafeRowAggBuffer =
/* 130 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
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
/* 142 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
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
/* 159 */         boolean agg_isNull13 = true;
/* 160 */         double agg_value15 = -1.0;
/* 161 */
/* 162 */         boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 163 */         double agg_value17 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 164 */         boolean agg_isNull14 = agg_isNull15;
/* 165 */         double agg_value16 = agg_value17;
/* 166 */         if (agg_isNull14) {
/* 167 */           boolean agg_isNull16 = false;
/* 168 */           double agg_value18 = -1.0;
/* 169 */           if (!false) {
/* 170 */             agg_value18 = (double) 0;
/* 171 */           }
/* 172 */           if (!agg_isNull16) {
/* 173 */             agg_isNull14 = false;
/* 174 */             agg_value16 = agg_value18;
/* 175 */           }
/* 176 */         }
/* 177 */
/* 178 */         if (!inputadapter_isNull3) {
/* 179 */           agg_isNull13 = false; // resultCode could change nullability.
/* 180 */           agg_value15 = agg_value16 + inputadapter_value3;
/* 181 */
/* 182 */         }
/* 183 */         boolean agg_isNull12 = agg_isNull13;
/* 184 */         double agg_value14 = agg_value15;
/* 185 */         if (agg_isNull12) {
/* 186 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 187 */           double agg_value21 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 188 */           if (!agg_isNull19) {
/* 189 */             agg_isNull12 = false;
/* 190 */             agg_value14 = agg_value21;
/* 191 */           }
/* 192 */         }
/* 193 */         boolean agg_isNull21 = true;
/* 194 */         double agg_value23 = -1.0;
/* 195 */
/* 196 */         boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 197 */         double agg_value25 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 198 */         boolean agg_isNull22 = agg_isNull23;
/* 199 */         double agg_value24 = agg_value25;
/* 200 */         if (agg_isNull22) {
/* 201 */           boolean agg_isNull24 = false;
/* 202 */           double agg_value26 = -1.0;
/* 203 */           if (!false) {
/* 204 */             agg_value26 = (double) 0;
/* 205 */           }
/* 206 */           if (!agg_isNull24) {
/* 207 */             agg_isNull22 = false;
/* 208 */             agg_value24 = agg_value26;
/* 209 */           }
/* 210 */         }
/* 211 */
/* 212 */         if (!inputadapter_isNull4) {
/* 213 */           agg_isNull21 = false; // resultCode could change nullability.
/* 214 */           agg_value23 = agg_value24 + inputadapter_value4;
/* 215 */
/* 216 */         }
/* 217 */         boolean agg_isNull20 = agg_isNull21;
/* 218 */         double agg_value22 = agg_value23;
/* 219 */         if (agg_isNull20) {
/* 220 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 221 */           double agg_value29 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 222 */           if (!agg_isNull27) {
/* 223 */             agg_isNull20 = false;
/* 224 */             agg_value22 = agg_value29;
/* 225 */           }
/* 226 */         }
/* 227 */         // update unsafe row buffer
/* 228 */         if (!agg_isNull12) {
/* 229 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value14);
/* 230 */         } else {
/* 231 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 232 */         }
/* 233 */
/* 234 */         if (!agg_isNull20) {
/* 235 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value22);
/* 236 */         } else {
/* 237 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 238 */         }
/* 239 */
/* 240 */       }
/* 241 */       if (shouldStop()) return;
/* 242 */     }
/* 243 */
/* 244 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 245 */   }
/* 246 */
/* 247 */   private void wholestagecodegen_init_1() {
/* 248 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 249 */     project_result = new UnsafeRow(4);
/* 250 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 251 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 252 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 253 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 254 */
/* 255 */   }
/* 256 */
/* 257 */   protected void processNext() throws java.io.IOException {
/* 258 */     if (!agg_initAgg) {
/* 259 */       agg_initAgg = true;
/* 260 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 261 */       agg_doAggregateWithKeys();
/* 262 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 263 */     }
/* 264 */
/* 265 */     // output the result
/* 266 */
/* 267 */     while (agg_mapIter.next()) {
/* 268 */       wholestagecodegen_numOutputRows.add(1);
/* 269 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 270 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 271 */
/* 272 */       boolean agg_isNull28 = agg_aggKey.isNullAt(0);
/* 273 */       UTF8String agg_value30 = agg_isNull28 ? null : (agg_aggKey.getUTF8String(0));
/* 274 */       boolean agg_isNull29 = agg_aggKey.isNullAt(1);
/* 275 */       UTF8String agg_value31 = agg_isNull29 ? null : (agg_aggKey.getUTF8String(1));
/* 276 */       boolean agg_isNull30 = agg_aggKey.isNullAt(2);
/* 277 */       UTF8String agg_value32 = agg_isNull30 ? null : (agg_aggKey.getUTF8String(2));
/* 278 */       boolean agg_isNull31 = agg_aggBuffer.isNullAt(0);
/* 279 */       double agg_value33 = agg_isNull31 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 280 */       boolean agg_isNull32 = agg_aggBuffer.isNullAt(1);
/* 281 */       double agg_value34 = agg_isNull32 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 282 */
/* 283 */       if (!(!(agg_isNull32))) continue;
/* 284 */
/* 285 */       boolean filter_isNull2 = true;
/* 286 */       boolean filter_value2 = false;
/* 287 */
/* 288 */       if (!false) {
/* 289 */         filter_isNull2 = false; // resultCode could change nullability.
/* 290 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value34, 86353.49132545803D) > 0;
/* 291 */
/* 292 */       }
/* 293 */       if (filter_isNull2 || !filter_value2) continue;
/* 294 */
/* 295 */       filter_numOutputRows.add(1);
/* 296 */
/* 297 */       project_holder.reset();
/* 298 */
/* 299 */       project_rowWriter.zeroOutNullBytes();
/* 300 */
/* 301 */       if (agg_isNull28) {
/* 302 */         project_rowWriter.setNullAt(0);
/* 303 */       } else {
/* 304 */         project_rowWriter.write(0, agg_value30);
/* 305 */       }
/* 306 */
/* 307 */       if (agg_isNull29) {
/* 308 */         project_rowWriter.setNullAt(1);
/* 309 */       } else {
/* 310 */         project_rowWriter.write(1, agg_value31);
/* 311 */       }
/* 312 */
/* 313 */       if (agg_isNull30) {
/* 314 */         project_rowWriter.setNullAt(2);
/* 315 */       } else {
/* 316 */         project_rowWriter.write(2, agg_value32);
/* 317 */       }
/* 318 */
/* 319 */       if (agg_isNull31) {
/* 320 */         project_rowWriter.setNullAt(3);
/* 321 */       } else {
/* 322 */         project_rowWriter.write(3, agg_value33);
/* 323 */       }
/* 324 */       project_result.setTotalSize(project_holder.totalSize());
/* 325 */       append(project_result);
/* 326 */
/* 327 */       if (shouldStop()) return;
/* 328 */     }
/* 329 */
/* 330 */     agg_mapIter.close();
/* 331 */     if (agg_sorter == null) {
/* 332 */       agg_hashMap.free();
/* 333 */     }
/* 334 */   }
/* 335 */ }
