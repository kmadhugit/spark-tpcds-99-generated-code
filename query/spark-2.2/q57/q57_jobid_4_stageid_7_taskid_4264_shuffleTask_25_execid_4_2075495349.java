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
/* 023 */   private int agg_value14;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     agg_initAgg = false;
/* 038 */
/* 039 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 040 */
/* 041 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 042 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 043 */     inputadapter_input = inputs[0];
/* 044 */     agg_result = new UnsafeRow(5);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(7);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 051 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 052 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 057 */     agg_hashMap = agg_plan.createHashMap();
/* 058 */
/* 059 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 062 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 067 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 068 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 069 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 070 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 071 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 072 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 073 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 074 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 075 */
/* 076 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 077 */
/* 078 */       UnsafeRow agg_fastAggBuffer = null;
/* 079 */
/* 080 */       if (agg_fastAggBuffer == null) {
/* 081 */         // generate grouping key
/* 082 */         agg_holder.reset();
/* 083 */
/* 084 */         agg_rowWriter.zeroOutNullBytes();
/* 085 */
/* 086 */         if (inputadapter_isNull) {
/* 087 */           agg_rowWriter.setNullAt(0);
/* 088 */         } else {
/* 089 */           agg_rowWriter.write(0, inputadapter_value);
/* 090 */         }
/* 091 */
/* 092 */         if (inputadapter_isNull1) {
/* 093 */           agg_rowWriter.setNullAt(1);
/* 094 */         } else {
/* 095 */           agg_rowWriter.write(1, inputadapter_value1);
/* 096 */         }
/* 097 */
/* 098 */         if (inputadapter_isNull2) {
/* 099 */           agg_rowWriter.setNullAt(2);
/* 100 */         } else {
/* 101 */           agg_rowWriter.write(2, inputadapter_value2);
/* 102 */         }
/* 103 */
/* 104 */         if (inputadapter_isNull3) {
/* 105 */           agg_rowWriter.setNullAt(3);
/* 106 */         } else {
/* 107 */           agg_rowWriter.write(3, inputadapter_value3);
/* 108 */         }
/* 109 */
/* 110 */         if (inputadapter_isNull4) {
/* 111 */           agg_rowWriter.setNullAt(4);
/* 112 */         } else {
/* 113 */           agg_rowWriter.write(4, inputadapter_value4);
/* 114 */         }
/* 115 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 116 */         agg_value14 = 42;
/* 117 */
/* 118 */         if (!inputadapter_isNull) {
/* 119 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value14);
/* 120 */         }
/* 121 */
/* 122 */         if (!inputadapter_isNull1) {
/* 123 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value14);
/* 124 */         }
/* 125 */
/* 126 */         if (!inputadapter_isNull2) {
/* 127 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value14);
/* 128 */         }
/* 129 */
/* 130 */         if (!inputadapter_isNull3) {
/* 131 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value14);
/* 132 */         }
/* 133 */
/* 134 */         if (!inputadapter_isNull4) {
/* 135 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value14);
/* 136 */         }
/* 137 */         if (true) {
/* 138 */           // try to get the buffer from hash map
/* 139 */           agg_unsafeRowAggBuffer =
/* 140 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 141 */         }
/* 142 */         if (agg_unsafeRowAggBuffer == null) {
/* 143 */           if (agg_sorter == null) {
/* 144 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 145 */           } else {
/* 146 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 147 */           }
/* 148 */
/* 149 */           // the hash map had be spilled, it should have enough memory now,
/* 150 */           // try  to allocate buffer again.
/* 151 */           agg_unsafeRowAggBuffer =
/* 152 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 153 */           if (agg_unsafeRowAggBuffer == null) {
/* 154 */             // failed to allocate the first page
/* 155 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 156 */           }
/* 157 */         }
/* 158 */       }
/* 159 */
/* 160 */       if (agg_fastAggBuffer != null) {
/* 161 */         // update fast row
/* 162 */
/* 163 */       } else {
/* 164 */         // update unsafe row
/* 165 */
/* 166 */         // common sub-expressions
/* 167 */
/* 168 */         // evaluate aggregate function
/* 169 */         boolean agg_isNull19 = true;
/* 170 */         double agg_value21 = -1.0;
/* 171 */
/* 172 */         boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 173 */         double agg_value23 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 174 */         boolean agg_isNull20 = agg_isNull21;
/* 175 */         double agg_value22 = agg_value23;
/* 176 */         if (agg_isNull20) {
/* 177 */           boolean agg_isNull22 = false;
/* 178 */           double agg_value24 = -1.0;
/* 179 */           if (!false) {
/* 180 */             agg_value24 = (double) 0;
/* 181 */           }
/* 182 */           if (!agg_isNull22) {
/* 183 */             agg_isNull20 = false;
/* 184 */             agg_value22 = agg_value24;
/* 185 */           }
/* 186 */         }
/* 187 */
/* 188 */         if (!inputadapter_isNull5) {
/* 189 */           agg_isNull19 = false; // resultCode could change nullability.
/* 190 */           agg_value21 = agg_value22 + inputadapter_value5;
/* 191 */
/* 192 */         }
/* 193 */         boolean agg_isNull18 = agg_isNull19;
/* 194 */         double agg_value20 = agg_value21;
/* 195 */         if (agg_isNull18) {
/* 196 */           boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 197 */           double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 198 */           if (!agg_isNull25) {
/* 199 */             agg_isNull18 = false;
/* 200 */             agg_value20 = agg_value27;
/* 201 */           }
/* 202 */         }
/* 203 */         boolean agg_isNull27 = true;
/* 204 */         double agg_value29 = -1.0;
/* 205 */
/* 206 */         boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 207 */         double agg_value31 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 208 */         boolean agg_isNull28 = agg_isNull29;
/* 209 */         double agg_value30 = agg_value31;
/* 210 */         if (agg_isNull28) {
/* 211 */           boolean agg_isNull30 = false;
/* 212 */           double agg_value32 = -1.0;
/* 213 */           if (!false) {
/* 214 */             agg_value32 = (double) 0;
/* 215 */           }
/* 216 */           if (!agg_isNull30) {
/* 217 */             agg_isNull28 = false;
/* 218 */             agg_value30 = agg_value32;
/* 219 */           }
/* 220 */         }
/* 221 */
/* 222 */         if (!inputadapter_isNull6) {
/* 223 */           agg_isNull27 = false; // resultCode could change nullability.
/* 224 */           agg_value29 = agg_value30 + inputadapter_value6;
/* 225 */
/* 226 */         }
/* 227 */         boolean agg_isNull26 = agg_isNull27;
/* 228 */         double agg_value28 = agg_value29;
/* 229 */         if (agg_isNull26) {
/* 230 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 231 */           double agg_value35 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 232 */           if (!agg_isNull33) {
/* 233 */             agg_isNull26 = false;
/* 234 */             agg_value28 = agg_value35;
/* 235 */           }
/* 236 */         }
/* 237 */         // update unsafe row buffer
/* 238 */         if (!agg_isNull18) {
/* 239 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value20);
/* 240 */         } else {
/* 241 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 242 */         }
/* 243 */
/* 244 */         if (!agg_isNull26) {
/* 245 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value28);
/* 246 */         } else {
/* 247 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 248 */         }
/* 249 */
/* 250 */       }
/* 251 */       if (shouldStop()) return;
/* 252 */     }
/* 253 */
/* 254 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
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
/* 272 */       boolean agg_isNull34 = agg_aggKey.isNullAt(0);
/* 273 */       UTF8String agg_value36 = agg_isNull34 ? null : (agg_aggKey.getUTF8String(0));
/* 274 */       boolean agg_isNull35 = agg_aggKey.isNullAt(1);
/* 275 */       UTF8String agg_value37 = agg_isNull35 ? null : (agg_aggKey.getUTF8String(1));
/* 276 */       boolean agg_isNull36 = agg_aggKey.isNullAt(2);
/* 277 */       UTF8String agg_value38 = agg_isNull36 ? null : (agg_aggKey.getUTF8String(2));
/* 278 */       boolean agg_isNull37 = agg_aggKey.isNullAt(3);
/* 279 */       int agg_value39 = agg_isNull37 ? -1 : (agg_aggKey.getInt(3));
/* 280 */       boolean agg_isNull38 = agg_aggKey.isNullAt(4);
/* 281 */       int agg_value40 = agg_isNull38 ? -1 : (agg_aggKey.getInt(4));
/* 282 */       boolean agg_isNull39 = agg_aggBuffer.isNullAt(0);
/* 283 */       double agg_value41 = agg_isNull39 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 284 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(1);
/* 285 */       double agg_value42 = agg_isNull40 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 286 */
/* 287 */       agg_holder1.reset();
/* 288 */
/* 289 */       agg_rowWriter1.zeroOutNullBytes();
/* 290 */
/* 291 */       if (agg_isNull34) {
/* 292 */         agg_rowWriter1.setNullAt(0);
/* 293 */       } else {
/* 294 */         agg_rowWriter1.write(0, agg_value36);
/* 295 */       }
/* 296 */
/* 297 */       if (agg_isNull35) {
/* 298 */         agg_rowWriter1.setNullAt(1);
/* 299 */       } else {
/* 300 */         agg_rowWriter1.write(1, agg_value37);
/* 301 */       }
/* 302 */
/* 303 */       if (agg_isNull36) {
/* 304 */         agg_rowWriter1.setNullAt(2);
/* 305 */       } else {
/* 306 */         agg_rowWriter1.write(2, agg_value38);
/* 307 */       }
/* 308 */
/* 309 */       if (agg_isNull37) {
/* 310 */         agg_rowWriter1.setNullAt(3);
/* 311 */       } else {
/* 312 */         agg_rowWriter1.write(3, agg_value39);
/* 313 */       }
/* 314 */
/* 315 */       if (agg_isNull38) {
/* 316 */         agg_rowWriter1.setNullAt(4);
/* 317 */       } else {
/* 318 */         agg_rowWriter1.write(4, agg_value40);
/* 319 */       }
/* 320 */
/* 321 */       if (agg_isNull39) {
/* 322 */         agg_rowWriter1.setNullAt(5);
/* 323 */       } else {
/* 324 */         agg_rowWriter1.write(5, agg_value41);
/* 325 */       }
/* 326 */
/* 327 */       if (agg_isNull40) {
/* 328 */         agg_rowWriter1.setNullAt(6);
/* 329 */       } else {
/* 330 */         agg_rowWriter1.write(6, agg_value42);
/* 331 */       }
/* 332 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 333 */       append(agg_result1);
/* 334 */
/* 335 */       if (shouldStop()) return;
/* 336 */     }
/* 337 */
/* 338 */     agg_mapIter.close();
/* 339 */     if (agg_sorter == null) {
/* 340 */       agg_hashMap.free();
/* 341 */     }
/* 342 */   }
/* 343 */ }
