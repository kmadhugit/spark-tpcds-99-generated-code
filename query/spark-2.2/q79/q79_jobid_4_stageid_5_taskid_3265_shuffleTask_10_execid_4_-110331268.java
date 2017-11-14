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
/* 023 */   private int agg_value12;
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
/* 044 */     agg_result = new UnsafeRow(4);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(5);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
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
/* 062 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 067 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 068 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 069 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 070 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 071 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 072 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 073 */
/* 074 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 075 */
/* 076 */       UnsafeRow agg_fastAggBuffer = null;
/* 077 */
/* 078 */       if (agg_fastAggBuffer == null) {
/* 079 */         // generate grouping key
/* 080 */         agg_holder.reset();
/* 081 */
/* 082 */         agg_rowWriter.zeroOutNullBytes();
/* 083 */
/* 084 */         if (inputadapter_isNull) {
/* 085 */           agg_rowWriter.setNullAt(0);
/* 086 */         } else {
/* 087 */           agg_rowWriter.write(0, inputadapter_value);
/* 088 */         }
/* 089 */
/* 090 */         if (inputadapter_isNull1) {
/* 091 */           agg_rowWriter.setNullAt(1);
/* 092 */         } else {
/* 093 */           agg_rowWriter.write(1, inputadapter_value1);
/* 094 */         }
/* 095 */
/* 096 */         if (inputadapter_isNull2) {
/* 097 */           agg_rowWriter.setNullAt(2);
/* 098 */         } else {
/* 099 */           agg_rowWriter.write(2, inputadapter_value2);
/* 100 */         }
/* 101 */
/* 102 */         if (inputadapter_isNull3) {
/* 103 */           agg_rowWriter.setNullAt(3);
/* 104 */         } else {
/* 105 */           agg_rowWriter.write(3, inputadapter_value3);
/* 106 */         }
/* 107 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 108 */         agg_value12 = 42;
/* 109 */
/* 110 */         if (!inputadapter_isNull) {
/* 111 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 112 */         }
/* 113 */
/* 114 */         if (!inputadapter_isNull1) {
/* 115 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull2) {
/* 119 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 120 */         }
/* 121 */
/* 122 */         if (!inputadapter_isNull3) {
/* 123 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value12);
/* 124 */         }
/* 125 */         if (true) {
/* 126 */           // try to get the buffer from hash map
/* 127 */           agg_unsafeRowAggBuffer =
/* 128 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 129 */         }
/* 130 */         if (agg_unsafeRowAggBuffer == null) {
/* 131 */           if (agg_sorter == null) {
/* 132 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 133 */           } else {
/* 134 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 135 */           }
/* 136 */
/* 137 */           // the hash map had be spilled, it should have enough memory now,
/* 138 */           // try  to allocate buffer again.
/* 139 */           agg_unsafeRowAggBuffer =
/* 140 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 141 */           if (agg_unsafeRowAggBuffer == null) {
/* 142 */             // failed to allocate the first page
/* 143 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 144 */           }
/* 145 */         }
/* 146 */       }
/* 147 */
/* 148 */       if (agg_fastAggBuffer != null) {
/* 149 */         // update fast row
/* 150 */
/* 151 */       } else {
/* 152 */         // update unsafe row
/* 153 */
/* 154 */         // common sub-expressions
/* 155 */
/* 156 */         // evaluate aggregate function
/* 157 */         boolean agg_isNull16 = true;
/* 158 */         double agg_value18 = -1.0;
/* 159 */
/* 160 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 161 */         double agg_value20 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 162 */         boolean agg_isNull17 = agg_isNull18;
/* 163 */         double agg_value19 = agg_value20;
/* 164 */         if (agg_isNull17) {
/* 165 */           boolean agg_isNull19 = false;
/* 166 */           double agg_value21 = -1.0;
/* 167 */           if (!false) {
/* 168 */             agg_value21 = (double) 0;
/* 169 */           }
/* 170 */           if (!agg_isNull19) {
/* 171 */             agg_isNull17 = false;
/* 172 */             agg_value19 = agg_value21;
/* 173 */           }
/* 174 */         }
/* 175 */
/* 176 */         if (!inputadapter_isNull4) {
/* 177 */           agg_isNull16 = false; // resultCode could change nullability.
/* 178 */           agg_value18 = agg_value19 + inputadapter_value4;
/* 179 */
/* 180 */         }
/* 181 */         boolean agg_isNull15 = agg_isNull16;
/* 182 */         double agg_value17 = agg_value18;
/* 183 */         if (agg_isNull15) {
/* 184 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 185 */           double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 186 */           if (!agg_isNull22) {
/* 187 */             agg_isNull15 = false;
/* 188 */             agg_value17 = agg_value24;
/* 189 */           }
/* 190 */         }
/* 191 */         boolean agg_isNull24 = true;
/* 192 */         double agg_value26 = -1.0;
/* 193 */
/* 194 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 195 */         double agg_value28 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 196 */         boolean agg_isNull25 = agg_isNull26;
/* 197 */         double agg_value27 = agg_value28;
/* 198 */         if (agg_isNull25) {
/* 199 */           boolean agg_isNull27 = false;
/* 200 */           double agg_value29 = -1.0;
/* 201 */           if (!false) {
/* 202 */             agg_value29 = (double) 0;
/* 203 */           }
/* 204 */           if (!agg_isNull27) {
/* 205 */             agg_isNull25 = false;
/* 206 */             agg_value27 = agg_value29;
/* 207 */           }
/* 208 */         }
/* 209 */
/* 210 */         if (!inputadapter_isNull5) {
/* 211 */           agg_isNull24 = false; // resultCode could change nullability.
/* 212 */           agg_value26 = agg_value27 + inputadapter_value5;
/* 213 */
/* 214 */         }
/* 215 */         boolean agg_isNull23 = agg_isNull24;
/* 216 */         double agg_value25 = agg_value26;
/* 217 */         if (agg_isNull23) {
/* 218 */           boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 219 */           double agg_value32 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 220 */           if (!agg_isNull30) {
/* 221 */             agg_isNull23 = false;
/* 222 */             agg_value25 = agg_value32;
/* 223 */           }
/* 224 */         }
/* 225 */         // update unsafe row buffer
/* 226 */         if (!agg_isNull15) {
/* 227 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value17);
/* 228 */         } else {
/* 229 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 230 */         }
/* 231 */
/* 232 */         if (!agg_isNull23) {
/* 233 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value25);
/* 234 */         } else {
/* 235 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 236 */         }
/* 237 */
/* 238 */       }
/* 239 */       if (shouldStop()) return;
/* 240 */     }
/* 241 */
/* 242 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 243 */   }
/* 244 */
/* 245 */   protected void processNext() throws java.io.IOException {
/* 246 */     if (!agg_initAgg) {
/* 247 */       agg_initAgg = true;
/* 248 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 249 */       agg_doAggregateWithKeys();
/* 250 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 251 */     }
/* 252 */
/* 253 */     // output the result
/* 254 */
/* 255 */     while (agg_mapIter.next()) {
/* 256 */       wholestagecodegen_numOutputRows.add(1);
/* 257 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 258 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 259 */
/* 260 */       boolean agg_isNull31 = agg_aggKey.isNullAt(0);
/* 261 */       int agg_value33 = agg_isNull31 ? -1 : (agg_aggKey.getInt(0));
/* 262 */       boolean agg_isNull32 = agg_aggKey.isNullAt(1);
/* 263 */       int agg_value34 = agg_isNull32 ? -1 : (agg_aggKey.getInt(1));
/* 264 */       boolean agg_isNull33 = agg_aggKey.isNullAt(2);
/* 265 */       int agg_value35 = agg_isNull33 ? -1 : (agg_aggKey.getInt(2));
/* 266 */       boolean agg_isNull34 = agg_aggKey.isNullAt(3);
/* 267 */       UTF8String agg_value36 = agg_isNull34 ? null : (agg_aggKey.getUTF8String(3));
/* 268 */       boolean agg_isNull35 = agg_aggBuffer.isNullAt(0);
/* 269 */       double agg_value37 = agg_isNull35 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 270 */       boolean agg_isNull36 = agg_aggBuffer.isNullAt(1);
/* 271 */       double agg_value38 = agg_isNull36 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 272 */
/* 273 */       agg_holder1.reset();
/* 274 */
/* 275 */       agg_rowWriter1.zeroOutNullBytes();
/* 276 */
/* 277 */       if (agg_isNull31) {
/* 278 */         agg_rowWriter1.setNullAt(0);
/* 279 */       } else {
/* 280 */         agg_rowWriter1.write(0, agg_value33);
/* 281 */       }
/* 282 */
/* 283 */       if (agg_isNull32) {
/* 284 */         agg_rowWriter1.setNullAt(1);
/* 285 */       } else {
/* 286 */         agg_rowWriter1.write(1, agg_value34);
/* 287 */       }
/* 288 */
/* 289 */       if (agg_isNull34) {
/* 290 */         agg_rowWriter1.setNullAt(2);
/* 291 */       } else {
/* 292 */         agg_rowWriter1.write(2, agg_value36);
/* 293 */       }
/* 294 */
/* 295 */       if (agg_isNull35) {
/* 296 */         agg_rowWriter1.setNullAt(3);
/* 297 */       } else {
/* 298 */         agg_rowWriter1.write(3, agg_value37);
/* 299 */       }
/* 300 */
/* 301 */       if (agg_isNull36) {
/* 302 */         agg_rowWriter1.setNullAt(4);
/* 303 */       } else {
/* 304 */         agg_rowWriter1.write(4, agg_value38);
/* 305 */       }
/* 306 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 307 */       append(agg_result1);
/* 308 */
/* 309 */       if (shouldStop()) return;
/* 310 */     }
/* 311 */
/* 312 */     agg_mapIter.close();
/* 313 */     if (agg_sorter == null) {
/* 314 */       agg_hashMap.free();
/* 315 */     }
/* 316 */   }
/* 317 */ }
