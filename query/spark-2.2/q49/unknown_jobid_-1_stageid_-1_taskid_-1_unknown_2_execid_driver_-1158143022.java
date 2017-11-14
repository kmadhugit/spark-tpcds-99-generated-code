/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private UnsafeRow agg_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 019 */   private int agg_value10;
/* 020 */   private UnsafeRow agg_result1;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 025 */
/* 026 */   public GeneratedIterator(Object[] references) {
/* 027 */     this.references = references;
/* 028 */   }
/* 029 */
/* 030 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 031 */     partitionIndex = index;
/* 032 */     this.inputs = inputs;
/* 033 */     agg_initAgg = false;
/* 034 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 035 */
/* 036 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 037 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 038 */     inputadapter_input = inputs[0];
/* 039 */     agg_result = new UnsafeRow(5);
/* 040 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 041 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 042 */
/* 043 */     agg_result1 = new UnsafeRow(5);
/* 044 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 045 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 046 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 047 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 052 */     agg_hashMap = agg_plan.createHashMap();
/* 053 */
/* 054 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 055 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 056 */       UTF8String inputadapter_value = inputadapter_row.getUTF8String(0);
/* 057 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 058 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 059 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 060 */       Decimal inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getDecimal(2, 35, 20));
/* 061 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 062 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 063 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 064 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 065 */
/* 066 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 067 */
/* 068 */       UnsafeRow agg_fastAggBuffer = null;
/* 069 */
/* 070 */       if (agg_fastAggBuffer == null) {
/* 071 */         // generate grouping key
/* 072 */         agg_holder.reset();
/* 073 */
/* 074 */         agg_rowWriter.zeroOutNullBytes();
/* 075 */
/* 076 */         agg_rowWriter.write(0, inputadapter_value);
/* 077 */
/* 078 */         if (inputadapter_isNull1) {
/* 079 */           agg_rowWriter.setNullAt(1);
/* 080 */         } else {
/* 081 */           agg_rowWriter.write(1, inputadapter_value1);
/* 082 */         }
/* 083 */
/* 084 */         if (inputadapter_isNull2) {
/* 085 */           agg_rowWriter.write(2, (Decimal) null, 35, 20);
/* 086 */         } else {
/* 087 */           agg_rowWriter.write(2, inputadapter_value2, 35, 20);
/* 088 */         }
/* 089 */
/* 090 */         if (inputadapter_isNull3) {
/* 091 */           agg_rowWriter.setNullAt(3);
/* 092 */         } else {
/* 093 */           agg_rowWriter.write(3, inputadapter_value3);
/* 094 */         }
/* 095 */
/* 096 */         if (inputadapter_isNull4) {
/* 097 */           agg_rowWriter.setNullAt(4);
/* 098 */         } else {
/* 099 */           agg_rowWriter.write(4, inputadapter_value4);
/* 100 */         }
/* 101 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 102 */         agg_value10 = 42;
/* 103 */
/* 104 */         agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value10);
/* 105 */
/* 106 */         if (!inputadapter_isNull1) {
/* 107 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value10);
/* 108 */         }
/* 109 */
/* 110 */         if (!inputadapter_isNull2) {
/* 111 */           final byte[] agg_bytes = inputadapter_value2.toJavaBigDecimal().unscaledValue().toByteArray();
/* 112 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(agg_bytes, Platform.BYTE_ARRAY_OFFSET, agg_bytes.length, agg_value10);
/* 113 */
/* 114 */         }
/* 115 */
/* 116 */         if (!inputadapter_isNull3) {
/* 117 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value10);
/* 118 */         }
/* 119 */
/* 120 */         if (!inputadapter_isNull4) {
/* 121 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value10);
/* 122 */         }
/* 123 */         if (true) {
/* 124 */           // try to get the buffer from hash map
/* 125 */           agg_unsafeRowAggBuffer =
/* 126 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 127 */         }
/* 128 */         if (agg_unsafeRowAggBuffer == null) {
/* 129 */           if (agg_sorter == null) {
/* 130 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 131 */           } else {
/* 132 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 133 */           }
/* 134 */
/* 135 */           // the hash map had be spilled, it should have enough memory now,
/* 136 */           // try  to allocate buffer again.
/* 137 */           agg_unsafeRowAggBuffer =
/* 138 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 139 */           if (agg_unsafeRowAggBuffer == null) {
/* 140 */             // failed to allocate the first page
/* 141 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 142 */           }
/* 143 */         }
/* 144 */       }
/* 145 */
/* 146 */       if (agg_fastAggBuffer != null) {
/* 147 */         // update fast row
/* 148 */
/* 149 */       } else {
/* 150 */         // update unsafe row
/* 151 */
/* 152 */         // common sub-expressions
/* 153 */
/* 154 */         // evaluate aggregate function
/* 155 */
/* 156 */         // update unsafe row buffer
/* 157 */
/* 158 */       }
/* 159 */       if (shouldStop()) return;
/* 160 */     }
/* 161 */
/* 162 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 163 */   }
/* 164 */
/* 165 */   protected void processNext() throws java.io.IOException {
/* 166 */     if (!agg_initAgg) {
/* 167 */       agg_initAgg = true;
/* 168 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 169 */       agg_doAggregateWithKeys();
/* 170 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 171 */     }
/* 172 */
/* 173 */     // output the result
/* 174 */
/* 175 */     while (agg_mapIter.next()) {
/* 176 */       wholestagecodegen_numOutputRows.add(1);
/* 177 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 178 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 179 */
/* 180 */       UTF8String agg_value16 = agg_aggKey.getUTF8String(0);
/* 181 */       boolean agg_isNull17 = agg_aggKey.isNullAt(1);
/* 182 */       int agg_value17 = agg_isNull17 ? -1 : (agg_aggKey.getInt(1));
/* 183 */       boolean agg_isNull18 = agg_aggKey.isNullAt(2);
/* 184 */       Decimal agg_value18 = agg_isNull18 ? null : (agg_aggKey.getDecimal(2, 35, 20));
/* 185 */       boolean agg_isNull19 = agg_aggKey.isNullAt(3);
/* 186 */       int agg_value19 = agg_isNull19 ? -1 : (agg_aggKey.getInt(3));
/* 187 */       boolean agg_isNull20 = agg_aggKey.isNullAt(4);
/* 188 */       int agg_value20 = agg_isNull20 ? -1 : (agg_aggKey.getInt(4));
/* 189 */       agg_holder1.reset();
/* 190 */
/* 191 */       agg_rowWriter1.zeroOutNullBytes();
/* 192 */
/* 193 */       agg_rowWriter1.write(0, agg_value16);
/* 194 */
/* 195 */       if (agg_isNull17) {
/* 196 */         agg_rowWriter1.setNullAt(1);
/* 197 */       } else {
/* 198 */         agg_rowWriter1.write(1, agg_value17);
/* 199 */       }
/* 200 */
/* 201 */       if (agg_isNull18) {
/* 202 */         agg_rowWriter1.write(2, (Decimal) null, 35, 20);
/* 203 */       } else {
/* 204 */         agg_rowWriter1.write(2, agg_value18, 35, 20);
/* 205 */       }
/* 206 */
/* 207 */       if (agg_isNull19) {
/* 208 */         agg_rowWriter1.setNullAt(3);
/* 209 */       } else {
/* 210 */         agg_rowWriter1.write(3, agg_value19);
/* 211 */       }
/* 212 */
/* 213 */       if (agg_isNull20) {
/* 214 */         agg_rowWriter1.setNullAt(4);
/* 215 */       } else {
/* 216 */         agg_rowWriter1.write(4, agg_value20);
/* 217 */       }
/* 218 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 219 */       append(agg_result1);
/* 220 */
/* 221 */       if (shouldStop()) return;
/* 222 */     }
/* 223 */
/* 224 */     agg_mapIter.close();
/* 225 */     if (agg_sorter == null) {
/* 226 */       agg_hashMap.free();
/* 227 */     }
/* 228 */   }
/* 229 */ }
