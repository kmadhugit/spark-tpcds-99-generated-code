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
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private UnsafeRow scan_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 023 */   private UnsafeRow filter_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 026 */   private UnsafeRow project_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     wholestagecodegen_init_0();
/* 038 */     wholestagecodegen_init_1();
/* 039 */
/* 040 */   }
/* 041 */
/* 042 */   private void wholestagecodegen_init_0() {
/* 043 */     scan_input = inputs[0];
/* 044 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 045 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     scan_scanTime1 = 0;
/* 047 */     scan_batch = null;
/* 048 */     scan_batchIdx = 0;
/* 049 */     scan_colInstance0 = null;
/* 050 */     scan_colInstance1 = null;
/* 051 */     scan_colInstance2 = null;
/* 052 */     scan_colInstance3 = null;
/* 053 */     scan_colInstance4 = null;
/* 054 */     scan_result = new UnsafeRow(5);
/* 055 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 056 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 057 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 058 */     filter_result = new UnsafeRow(5);
/* 059 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 060 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 061 */     project_result = new UnsafeRow(4);
/* 062 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void scan_nextBatch() throws java.io.IOException {
/* 067 */     long getBatchStart = System.nanoTime();
/* 068 */     if (scan_input.hasNext()) {
/* 069 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 070 */       scan_numOutputRows.add(scan_batch.numRows());
/* 071 */       scan_batchIdx = 0;
/* 072 */       scan_colInstance0 = scan_batch.column(0);
/* 073 */       scan_colInstance1 = scan_batch.column(1);
/* 074 */       scan_colInstance2 = scan_batch.column(2);
/* 075 */       scan_colInstance3 = scan_batch.column(3);
/* 076 */       scan_colInstance4 = scan_batch.column(4);
/* 077 */
/* 078 */     }
/* 079 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 080 */   }
/* 081 */
/* 082 */   private void wholestagecodegen_init_1() {
/* 083 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */   protected void processNext() throws java.io.IOException {
/* 088 */     if (scan_batch == null) {
/* 089 */       scan_nextBatch();
/* 090 */     }
/* 091 */     while (scan_batch != null) {
/* 092 */       int scan_numRows = scan_batch.numRows();
/* 093 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 094 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 095 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 096 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 097 */         double scan_value3 = scan_isNull3 ? -1.0 : (scan_colInstance3.getDouble(scan_rowIdx));
/* 098 */
/* 099 */         if (!(!(scan_isNull3))) continue;
/* 100 */
/* 101 */         boolean filter_isNull2 = false;
/* 102 */
/* 103 */         boolean filter_value2 = false;
/* 104 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value3, 68.0D) >= 0;
/* 105 */         if (!filter_value2) continue;
/* 106 */         boolean filter_isNull5 = false;
/* 107 */
/* 108 */         boolean filter_value5 = false;
/* 109 */         filter_value5 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value3, 98.0D) <= 0;
/* 110 */         if (!filter_value5) continue;
/* 111 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 112 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 113 */
/* 114 */         boolean filter_value8 = false;
/* 115 */         boolean filter_isNull8 = scan_isNull4;
/* 116 */         if (!filter_isNull8) {
/* 117 */           if (!filter_value8) {
/* 118 */             if (false) {
/* 119 */               filter_isNull8 = true;
/* 120 */             } else if (scan_value4 == 677) {
/* 121 */               filter_isNull8 = false;
/* 122 */               filter_value8 = true;
/* 123 */             }
/* 124 */           }
/* 125 */
/* 126 */           if (!filter_value8) {
/* 127 */             if (false) {
/* 128 */               filter_isNull8 = true;
/* 129 */             } else if (scan_value4 == 940) {
/* 130 */               filter_isNull8 = false;
/* 131 */               filter_value8 = true;
/* 132 */             }
/* 133 */           }
/* 134 */
/* 135 */           if (!filter_value8) {
/* 136 */             if (false) {
/* 137 */               filter_isNull8 = true;
/* 138 */             } else if (scan_value4 == 694) {
/* 139 */               filter_isNull8 = false;
/* 140 */               filter_value8 = true;
/* 141 */             }
/* 142 */           }
/* 143 */
/* 144 */           if (!filter_value8) {
/* 145 */             if (false) {
/* 146 */               filter_isNull8 = true;
/* 147 */             } else if (scan_value4 == 808) {
/* 148 */               filter_isNull8 = false;
/* 149 */               filter_value8 = true;
/* 150 */             }
/* 151 */           }
/* 152 */
/* 153 */         }
/* 154 */         if (filter_isNull8 || !filter_value8) continue;
/* 155 */
/* 156 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 157 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 158 */
/* 159 */         if (!(!(scan_isNull))) continue;
/* 160 */
/* 161 */         filter_numOutputRows.add(1);
/* 162 */
/* 163 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 164 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 165 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 166 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 167 */         project_holder.reset();
/* 168 */
/* 169 */         project_rowWriter.zeroOutNullBytes();
/* 170 */
/* 171 */         project_rowWriter.write(0, scan_value);
/* 172 */
/* 173 */         if (scan_isNull1) {
/* 174 */           project_rowWriter.setNullAt(1);
/* 175 */         } else {
/* 176 */           project_rowWriter.write(1, scan_value1);
/* 177 */         }
/* 178 */
/* 179 */         if (scan_isNull2) {
/* 180 */           project_rowWriter.setNullAt(2);
/* 181 */         } else {
/* 182 */           project_rowWriter.write(2, scan_value2);
/* 183 */         }
/* 184 */
/* 185 */         project_rowWriter.write(3, scan_value3);
/* 186 */         project_result.setTotalSize(project_holder.totalSize());
/* 187 */         append(project_result);
/* 188 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 189 */       }
/* 190 */       scan_batchIdx = scan_numRows;
/* 191 */       scan_batch = null;
/* 192 */       scan_nextBatch();
/* 193 */     }
/* 194 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 195 */     scan_scanTime1 = 0;
/* 196 */   }
/* 197 */ }
