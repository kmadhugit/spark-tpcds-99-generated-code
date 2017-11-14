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
/* 053 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 054 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 055 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     filter_result = new UnsafeRow(4);
/* 057 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 058 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 059 */     project_result = new UnsafeRow(2);
/* 060 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
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
/* 080 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   protected void processNext() throws java.io.IOException {
/* 085 */     if (scan_batch == null) {
/* 086 */       scan_nextBatch();
/* 087 */     }
/* 088 */     while (scan_batch != null) {
/* 089 */       int numRows = scan_batch.numRows();
/* 090 */       while (scan_batchIdx < numRows) {
/* 091 */         int scan_rowIdx = scan_batchIdx++;
/* 092 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 093 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 094 */
/* 095 */         boolean filter_value = false;
/* 096 */         boolean filter_isNull = scan_isNull2;
/* 097 */         if (!filter_isNull) {
/* 098 */           if (!filter_value) {
/* 099 */             Object filter_obj = ((Expression) references[3]).eval(null);
/* 100 */             UTF8String filter_value2 = (UTF8String) filter_obj;
/* 101 */             if (false) {
/* 102 */               filter_isNull = true;
/* 103 */             } else if (scan_value2.equals(filter_value2)) {
/* 104 */               filter_isNull = false;
/* 105 */               filter_value = true;
/* 106 */             }
/* 107 */           }
/* 108 */
/* 109 */           if (!filter_value) {
/* 110 */             Object filter_obj1 = ((Expression) references[4]).eval(null);
/* 111 */             UTF8String filter_value3 = (UTF8String) filter_obj1;
/* 112 */             if (false) {
/* 113 */               filter_isNull = true;
/* 114 */             } else if (scan_value2.equals(filter_value3)) {
/* 115 */               filter_isNull = false;
/* 116 */               filter_value = true;
/* 117 */             }
/* 118 */           }
/* 119 */
/* 120 */           if (!filter_value) {
/* 121 */             Object filter_obj2 = ((Expression) references[5]).eval(null);
/* 122 */             UTF8String filter_value4 = (UTF8String) filter_obj2;
/* 123 */             if (false) {
/* 124 */               filter_isNull = true;
/* 125 */             } else if (scan_value2.equals(filter_value4)) {
/* 126 */               filter_isNull = false;
/* 127 */               filter_value = true;
/* 128 */             }
/* 129 */           }
/* 130 */
/* 131 */           if (!filter_value) {
/* 132 */             Object filter_obj3 = ((Expression) references[6]).eval(null);
/* 133 */             UTF8String filter_value5 = (UTF8String) filter_obj3;
/* 134 */             if (false) {
/* 135 */               filter_isNull = true;
/* 136 */             } else if (scan_value2.equals(filter_value5)) {
/* 137 */               filter_isNull = false;
/* 138 */               filter_value = true;
/* 139 */             }
/* 140 */           }
/* 141 */
/* 142 */           if (!filter_value) {
/* 143 */             Object filter_obj4 = ((Expression) references[7]).eval(null);
/* 144 */             UTF8String filter_value6 = (UTF8String) filter_obj4;
/* 145 */             if (false) {
/* 146 */               filter_isNull = true;
/* 147 */             } else if (scan_value2.equals(filter_value6)) {
/* 148 */               filter_isNull = false;
/* 149 */               filter_value = true;
/* 150 */             }
/* 151 */           }
/* 152 */
/* 153 */           if (!filter_value) {
/* 154 */             Object filter_obj5 = ((Expression) references[8]).eval(null);
/* 155 */             UTF8String filter_value7 = (UTF8String) filter_obj5;
/* 156 */             if (false) {
/* 157 */               filter_isNull = true;
/* 158 */             } else if (scan_value2.equals(filter_value7)) {
/* 159 */               filter_isNull = false;
/* 160 */               filter_value = true;
/* 161 */             }
/* 162 */           }
/* 163 */
/* 164 */         }
/* 165 */         if (filter_isNull || !filter_value) continue;
/* 166 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 167 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 168 */
/* 169 */         if (!(!(scan_isNull1))) continue;
/* 170 */
/* 171 */         boolean filter_isNull10 = false;
/* 172 */
/* 173 */         boolean filter_value10 = false;
/* 174 */         filter_value10 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, 64.0D) >= 0;
/* 175 */         if (!filter_value10) continue;
/* 176 */         boolean filter_isNull13 = false;
/* 177 */
/* 178 */         boolean filter_value13 = false;
/* 179 */         filter_value13 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, 74.0D) <= 0;
/* 180 */         if (!filter_value13) continue;
/* 181 */         boolean filter_isNull16 = false;
/* 182 */
/* 183 */         boolean filter_value16 = false;
/* 184 */         filter_value16 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, 65.0D) >= 0;
/* 185 */         if (!filter_value16) continue;
/* 186 */         boolean filter_isNull19 = false;
/* 187 */
/* 188 */         boolean filter_value19 = false;
/* 189 */         filter_value19 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, 79.0D) <= 0;
/* 190 */         if (!filter_value19) continue;
/* 191 */
/* 192 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 193 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 194 */
/* 195 */         if (!(!(scan_isNull))) continue;
/* 196 */
/* 197 */         filter_numOutputRows.add(1);
/* 198 */
/* 199 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 200 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 201 */         project_holder.reset();
/* 202 */
/* 203 */         project_rowWriter.zeroOutNullBytes();
/* 204 */
/* 205 */         project_rowWriter.write(0, scan_value);
/* 206 */
/* 207 */         if (scan_isNull3) {
/* 208 */           project_rowWriter.setNullAt(1);
/* 209 */         } else {
/* 210 */           project_rowWriter.write(1, scan_value3);
/* 211 */         }
/* 212 */         project_result.setTotalSize(project_holder.totalSize());
/* 213 */         append(project_result);
/* 214 */         if (shouldStop()) return;
/* 215 */       }
/* 216 */       scan_batch = null;
/* 217 */       scan_nextBatch();
/* 218 */     }
/* 219 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 220 */     scan_scanTime1 = 0;
/* 221 */   }
/* 222 */ }
