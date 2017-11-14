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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value12;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 038 */
/* 039 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 041 */     inputadapter_input = inputs[0];
/* 042 */     agg_result = new UnsafeRow(5);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 045 */
/* 046 */     agg_result1 = new UnsafeRow(6);
/* 047 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 048 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 6);
/* 049 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 050 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 055 */     agg_hashMap = agg_plan.createHashMap();
/* 056 */
/* 057 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 058 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 059 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 060 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 061 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 062 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 063 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 064 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 065 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 066 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 067 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 068 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 069 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 070 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 071 */
/* 072 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 073 */
/* 074 */       UnsafeRow agg_fastAggBuffer = null;
/* 075 */
/* 076 */       if (agg_fastAggBuffer == null) {
/* 077 */         // generate grouping key
/* 078 */         agg_holder.reset();
/* 079 */
/* 080 */         agg_rowWriter.zeroOutNullBytes();
/* 081 */
/* 082 */         if (inputadapter_isNull) {
/* 083 */           agg_rowWriter.setNullAt(0);
/* 084 */         } else {
/* 085 */           agg_rowWriter.write(0, inputadapter_value);
/* 086 */         }
/* 087 */
/* 088 */         if (inputadapter_isNull1) {
/* 089 */           agg_rowWriter.setNullAt(1);
/* 090 */         } else {
/* 091 */           agg_rowWriter.write(1, inputadapter_value1);
/* 092 */         }
/* 093 */
/* 094 */         if (inputadapter_isNull2) {
/* 095 */           agg_rowWriter.setNullAt(2);
/* 096 */         } else {
/* 097 */           agg_rowWriter.write(2, inputadapter_value2);
/* 098 */         }
/* 099 */
/* 100 */         if (inputadapter_isNull3) {
/* 101 */           agg_rowWriter.setNullAt(3);
/* 102 */         } else {
/* 103 */           agg_rowWriter.write(3, inputadapter_value3);
/* 104 */         }
/* 105 */
/* 106 */         if (inputadapter_isNull4) {
/* 107 */           agg_rowWriter.setNullAt(4);
/* 108 */         } else {
/* 109 */           agg_rowWriter.write(4, inputadapter_value4);
/* 110 */         }
/* 111 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 112 */         agg_value12 = 42;
/* 113 */
/* 114 */         if (!inputadapter_isNull) {
/* 115 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value12);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull1) {
/* 119 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value12);
/* 120 */         }
/* 121 */
/* 122 */         if (!inputadapter_isNull2) {
/* 123 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value12);
/* 124 */         }
/* 125 */
/* 126 */         if (!inputadapter_isNull3) {
/* 127 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value12);
/* 128 */         }
/* 129 */
/* 130 */         if (!inputadapter_isNull4) {
/* 131 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value12);
/* 132 */         }
/* 133 */         if (true) {
/* 134 */           // try to get the buffer from hash map
/* 135 */           agg_unsafeRowAggBuffer =
/* 136 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 137 */         }
/* 138 */         if (agg_unsafeRowAggBuffer == null) {
/* 139 */           if (agg_sorter == null) {
/* 140 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 141 */           } else {
/* 142 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 143 */           }
/* 144 */
/* 145 */           // the hash map had be spilled, it should have enough memory now,
/* 146 */           // try  to allocate buffer again.
/* 147 */           agg_unsafeRowAggBuffer =
/* 148 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 149 */           if (agg_unsafeRowAggBuffer == null) {
/* 150 */             // failed to allocate the first page
/* 151 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 152 */           }
/* 153 */         }
/* 154 */       }
/* 155 */
/* 156 */       if (agg_fastAggBuffer != null) {
/* 157 */         // update fast row
/* 158 */
/* 159 */       } else {
/* 160 */         // update unsafe row
/* 161 */
/* 162 */         // common sub-expressions
/* 163 */
/* 164 */         // evaluate aggregate function
/* 165 */         boolean agg_isNull18 = true;
/* 166 */         double agg_value19 = -1.0;
/* 167 */
/* 168 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 169 */         double agg_value21 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 170 */         boolean agg_isNull19 = agg_isNull20;
/* 171 */         double agg_value20 = agg_value21;
/* 172 */         if (agg_isNull19) {
/* 173 */           boolean agg_isNull21 = false;
/* 174 */           double agg_value22 = -1.0;
/* 175 */           if (!false) {
/* 176 */             agg_value22 = (double) 0;
/* 177 */           }
/* 178 */           if (!agg_isNull21) {
/* 179 */             agg_isNull19 = false;
/* 180 */             agg_value20 = agg_value22;
/* 181 */           }
/* 182 */         }
/* 183 */
/* 184 */         if (!inputadapter_isNull5) {
/* 185 */           agg_isNull18 = false; // resultCode could change nullability.
/* 186 */           agg_value19 = agg_value20 + inputadapter_value5;
/* 187 */
/* 188 */         }
/* 189 */         boolean agg_isNull17 = agg_isNull18;
/* 190 */         double agg_value18 = agg_value19;
/* 191 */         if (agg_isNull17) {
/* 192 */           boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 193 */           double agg_value25 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 194 */           if (!agg_isNull24) {
/* 195 */             agg_isNull17 = false;
/* 196 */             agg_value18 = agg_value25;
/* 197 */           }
/* 198 */         }
/* 199 */         // update unsafe row buffer
/* 200 */         if (!agg_isNull17) {
/* 201 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 202 */         } else {
/* 203 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 204 */         }
/* 205 */
/* 206 */       }
/* 207 */       if (shouldStop()) return;
/* 208 */     }
/* 209 */
/* 210 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 211 */   }
/* 212 */
/* 213 */   protected void processNext() throws java.io.IOException {
/* 214 */     if (!agg_initAgg) {
/* 215 */       agg_initAgg = true;
/* 216 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 217 */       agg_doAggregateWithKeys();
/* 218 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 219 */     }
/* 220 */
/* 221 */     // output the result
/* 222 */
/* 223 */     while (agg_mapIter.next()) {
/* 224 */       wholestagecodegen_numOutputRows.add(1);
/* 225 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 226 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 227 */
/* 228 */       boolean agg_isNull25 = agg_aggKey.isNullAt(0);
/* 229 */       UTF8String agg_value26 = agg_isNull25 ? null : (agg_aggKey.getUTF8String(0));
/* 230 */       boolean agg_isNull26 = agg_aggKey.isNullAt(1);
/* 231 */       UTF8String agg_value27 = agg_isNull26 ? null : (agg_aggKey.getUTF8String(1));
/* 232 */       boolean agg_isNull27 = agg_aggKey.isNullAt(2);
/* 233 */       UTF8String agg_value28 = agg_isNull27 ? null : (agg_aggKey.getUTF8String(2));
/* 234 */       boolean agg_isNull28 = agg_aggKey.isNullAt(3);
/* 235 */       int agg_value29 = agg_isNull28 ? -1 : (agg_aggKey.getInt(3));
/* 236 */       boolean agg_isNull29 = agg_aggKey.isNullAt(4);
/* 237 */       int agg_value30 = agg_isNull29 ? -1 : (agg_aggKey.getInt(4));
/* 238 */       boolean agg_isNull30 = agg_aggBuffer.isNullAt(0);
/* 239 */       double agg_value31 = agg_isNull30 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 240 */
/* 241 */       agg_holder1.reset();
/* 242 */
/* 243 */       agg_rowWriter1.zeroOutNullBytes();
/* 244 */
/* 245 */       if (agg_isNull25) {
/* 246 */         agg_rowWriter1.setNullAt(0);
/* 247 */       } else {
/* 248 */         agg_rowWriter1.write(0, agg_value26);
/* 249 */       }
/* 250 */
/* 251 */       if (agg_isNull26) {
/* 252 */         agg_rowWriter1.setNullAt(1);
/* 253 */       } else {
/* 254 */         agg_rowWriter1.write(1, agg_value27);
/* 255 */       }
/* 256 */
/* 257 */       if (agg_isNull27) {
/* 258 */         agg_rowWriter1.setNullAt(2);
/* 259 */       } else {
/* 260 */         agg_rowWriter1.write(2, agg_value28);
/* 261 */       }
/* 262 */
/* 263 */       if (agg_isNull28) {
/* 264 */         agg_rowWriter1.setNullAt(3);
/* 265 */       } else {
/* 266 */         agg_rowWriter1.write(3, agg_value29);
/* 267 */       }
/* 268 */
/* 269 */       if (agg_isNull29) {
/* 270 */         agg_rowWriter1.setNullAt(4);
/* 271 */       } else {
/* 272 */         agg_rowWriter1.write(4, agg_value30);
/* 273 */       }
/* 274 */
/* 275 */       if (agg_isNull30) {
/* 276 */         agg_rowWriter1.setNullAt(5);
/* 277 */       } else {
/* 278 */         agg_rowWriter1.write(5, agg_value31);
/* 279 */       }
/* 280 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 281 */       append(agg_result1);
/* 282 */
/* 283 */       if (shouldStop()) return;
/* 284 */     }
/* 285 */
/* 286 */     agg_mapIter.close();
/* 287 */     if (agg_sorter == null) {
/* 288 */       agg_hashMap.free();
/* 289 */     }
/* 290 */   }
/* 291 */ }
